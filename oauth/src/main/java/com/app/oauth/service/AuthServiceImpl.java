package com.app.oauth.service;

import com.app.oauth.domain.dto.JwtTokenDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.domain.vo.SocialMemberVO;
import com.app.oauth.exception.JwtTokenException;
import com.app.oauth.exception.MemberException;
import com.app.oauth.repository.MemberDAO;
import com.app.oauth.repository.SocialMemberDAO;
import com.app.oauth.util.AuthCodeGenerator;
import com.app.oauth.util.JwtTokenUtil;
import com.app.oauth.util.SmsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional(rollbackFor = {Exception.class})
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.token-blacklist-prefix}")
    private String BLACK_LIST_PREFIX;

    @Value("${jwt.refresh-blacklist-prefix}")
    private String REFRESH_LIST_PREFIX;

    // 생성자 주입
    private final MemberDAO memberDAO;
    private final SocialMemberDAO socialMemberDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final RedisTemplate redisTemplate;
    private final SmsUtil smsUtil;



    @Override
    // 로컬 로그인
    public JwtTokenDTO login(MemberDTO memberDTO) {
        // 사용자 맞는지 (email = password = provider(local))
        // elary return
//       if(memberDAO.existByEmail(memberDTO.getMemberEmail())){
//           throw new MemberException("비회원", HttpStatus.BAD_REQUEST);
//       }

        MemberVO memberVO = MemberVO.from(memberDTO);
        log.info("memberDTO: {}", memberDTO);

        // 화면에서 받은 비밀번호를 단방향 암호화 비교
        // memberVO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword())); -> 이렇게 처리하면 안됨
        // -> 같은 비밀번호도 다르게 검사
        // 회원 유무검사
        MemberDTO foundMember = memberDAO.findByMemberEmail(memberDTO).orElseThrow(()-> {
            throw new MemberException("비회원", HttpStatus.BAD_REQUEST);
        });
        // 회원 비밀번호 검사
        if(!passwordEncoder.matches(memberVO.getMemberPassword(), foundMember.getMemberPassword())){
            throw new MemberException("비밀번호 불일치", HttpStatus.BAD_REQUEST);
        }

        // 토큰
        Map<String, String> claims = new HashMap<>();
        claims.put("id", foundMember.getId().toString());
        claims.put("memberEmail", foundMember.getMemberEmail());
        claims.put("socialMemberProvider", "local");

        String accessToken = jwtTokenUtil.generateAccessToken(claims);
        String refreshToken = jwtTokenUtil.generateRefreshToken(claims);

        log.info("accessToken: {}", accessToken);
        log.info("refreshToken: {}", refreshToken);

        JwtTokenDTO jwtTokenDTO = new JwtTokenDTO();

        jwtTokenDTO.setAccessToken(accessToken);
        jwtTokenDTO.setRefreshToken(refreshToken);

        // redis에 RefreshToken 저장
        saveRefreshToken(jwtTokenDTO);

        return jwtTokenDTO;
    }
    // 소셜 로그인
    @Override
    public JwtTokenDTO socialLogin(MemberDTO memberDTO) {

        JwtTokenDTO jwtTokenDTO = new JwtTokenDTO();
        Map<String, String> claims = new HashMap<String, String>();

        // 유저를 찾는다
        if(memberDAO.existByEmail(memberDTO)) {
            // 만약 유저가 있다면 -> 토큰발급(id)
            // 조회
            MemberDTO foundMember = memberDAO.findByMemberEmail(memberDTO).orElseThrow(() -> {throw new MemberException("socialLogin 회원 조회 실패", HttpStatus.BAD_REQUEST );});
            claims.put("id", foundMember.getId().toString());

        }else {
            // 만약 유저가 없다면 회원가입 후 -> 토큰발급
            MemberVO memberVO = MemberVO.from(memberDTO);
            SocialMemberVO socialMemberVO = SocialMemberVO.from(memberDTO);

            memberDAO.save(memberVO);
            socialMemberVO.setMemberId(memberVO.getId());

            socialMemberDAO.save(socialMemberVO);
            claims.put("id", memberVO.getId().toString());

        }
        claims.put("memberEmail", memberDTO.getMemberEmail());
        claims.put("socialMemberProvider", memberDTO.getSocialMemberProvider());

        String accessToken = jwtTokenUtil.generateAccessToken(claims);
        String refreshToken = jwtTokenUtil.generateRefreshToken(claims);

        jwtTokenDTO.setAccessToken(accessToken);
        jwtTokenDTO.setRefreshToken(refreshToken);

        // redis에 RefreshToken 저장
        saveRefreshToken(jwtTokenDTO);

        return jwtTokenDTO;

    }

    // 로그아웃
    // 실무에서는 Access Token을 받는것이 관례
    public void logout(JwtTokenDTO jwtTokenDTO){

        if(validateRefreshToken(jwtTokenDTO)){
            saveBlackListedToken(jwtTokenDTO);
        } else {
            throw new JwtTokenException("권한 없음", HttpStatus.UNAUTHORIZED);
        }
    }

    // Redis에 refresh Token 저장
    // 콜론체이닝(:) 방법으로 저장
    @Override
    public boolean saveRefreshToken(JwtTokenDTO jwtTokenDTO){
        String refreshToken = jwtTokenDTO.getRefreshToken();
        Long id = Long.parseLong((String)jwtTokenUtil.parseToken(refreshToken).get("id"));

        String key = REFRESH_LIST_PREFIX + id;

        try {
            redisTemplate.opsForValue().set(key, refreshToken, 30, TimeUnit.DAYS);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    // Redis에 저장된 refresh Token이 유효한지 검증
    @Override
    public boolean validateRefreshToken(JwtTokenDTO jwtTokenDTO){
        String refreshToken = jwtTokenDTO.getRefreshToken();
        Long id = Long.parseLong((String)jwtTokenUtil.parseToken(refreshToken).get("id"));
        String key = REFRESH_LIST_PREFIX + id;

//        return redisTemplate.opsForValue().getOperations().hasKey(key);
//        log.info("refreshToken.: {}", refreshToken.equals(storedToken));
//        log.info("storedToken: {}", storedToken);

        try {
            Object storedToken = redisTemplate.opsForValue().get(key);
            if(!refreshToken.equals(storedToken)){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Redis에 블랙리스트를 등록(로그아웃 시 토큰 무효화)
    @Override
    public boolean saveBlackListedToken(JwtTokenDTO jwtTokenDTO){

//        String refreshToken = null, accessToken = null, refreshKey = null, accessKey =  null;
//        Long refreshId = null, accessId = null;

        String refreshToken = jwtTokenDTO.getRefreshToken();
        Long refreshId = Long.parseLong((String)jwtTokenUtil.parseToken(refreshToken).get("id"));
        String refreshKey = REFRESH_LIST_PREFIX + refreshId;

        String accessToken = jwtTokenDTO.getAccessToken();
        Long accessId = Long.parseLong((String)jwtTokenUtil.parseToken(accessToken).get("id"));
        String accessKey = REFRESH_LIST_PREFIX + accessId;

        // try-> Ctrl + Alt + T
        try {
            redisTemplate.opsForSet().add(refreshKey, refreshToken);
            redisTemplate.opsForSet().add(accessKey, accessToken);
            // TTL
            redisTemplate.expire(refreshKey, 30, TimeUnit.DAYS);
            redisTemplate.expire(accessKey, 1, TimeUnit.DAYS);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    // Redis에 등록된 블랙리스트인지 검증
    @Override
    public boolean isBlackListedToken(JwtTokenDTO jwtTokenDTO) {
        String refreshToken = jwtTokenDTO.getRefreshToken();
        Long id = Long.parseLong((String)jwtTokenUtil.parseToken(refreshToken).get("id"));
        String key = BLACK_LIST_PREFIX + id;

        try {
            Boolean isMember = redisTemplate.opsForSet().isMember(key, refreshToken);
            return isMember != null && isMember;
        } catch (Exception e) {
            // false일때만 접근
            return false;
        }
    }


    // refresh 토큰을 검증하고, 새로운 accessToken 발급 서비스
    public JwtTokenDTO reIssueAccessToken(JwtTokenDTO jwtTokenDTO) {
        String refreshToken = jwtTokenDTO.getRefreshToken();
        Long id = Long.parseLong((String)jwtTokenUtil.parseToken(refreshToken).get("id"));

        if(isBlackListedToken(jwtTokenDTO)){
            throw new JwtTokenException("이미 로그아운 된 토큰입니다.", HttpStatus.BAD_REQUEST);
        }

        // refresh 검증
        if(!validateRefreshToken(jwtTokenDTO)){
            throw new JwtTokenException("유효하지 않는 토큰", HttpStatus.BAD_REQUEST);
        }

        Map<String, String> claims = new HashMap<>();
        MemberDTO member = memberDAO.findByMemberId(id).orElseThrow(() -> new MemberException("회원이 없음"));

        claims.put("id", member.getId().toString());
        claims.put("memberEmail", member.getMemberEmail());
        claims.put("provider", member.getSocialMemberProvider());

        // 새로운 토큰 생성
        String newAccessToken = jwtTokenUtil.generateAccessToken(claims);
        jwtTokenDTO.setAccessToken(newAccessToken);

        return jwtTokenDTO;
    }

    // 휴대폰 인증코드 발송
    @Override
    public boolean sendMemberPhoneVerificationCode(String memberPhone) {

        String message = null;
        String code = AuthCodeGenerator.generateAuthCode();
        message = "[123456789]\n["+ code +"]";
        smsUtil.sendOneMemberPhone(memberPhone, message);

        // redis 저장
        // phone: 01012345879:1234567
        String key = "phone" + memberPhone + ":" + code;


        try {
            redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 휴대폰 인증코드 검증
    @Override
    public boolean verifyMemberPhoneVerificationCode(String memberPhone, String code) {

        String key = "phone" + memberPhone + ":" + code;

        // 글로벌 핸들러 만들기
        // 컨드롤러쪽에서 리턴할수있게 처리 -> 직접하기

        try {

            String storedCode = String.valueOf(redisTemplate.opsForValue().get(key));
            redisTemplate.delete(key); // 검증끝나고 삭제

            return code.equals(storedCode);

        } catch (Exception e) {
            return false;
        }
    }

    // 이메일 인증코드 발송
    @Override
    public boolean sendMemberEmailVerificationCode(String memberEmail) {

        String message = null;
        String code = AuthCodeGenerator.generateAuthCode();
        message = "["+ code +"]";
        smsUtil.sendMemberEmail(memberEmail, "이메일 인증번호", message);

        // redis 저장
        String key = "email" + memberEmail + ":" + code;


        try {
            redisTemplate.opsForValue().set(key, code, 3, TimeUnit.MINUTES);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 이메일 인증코드 검증
    @Override
    public boolean verifyMemberEmailVerificationCode(String memberEmail, String code) {
        String key = "email" + memberEmail + ":" + code;


        try {

            String storedCode = String.valueOf(redisTemplate.opsForValue().get(key));
            redisTemplate.delete(key); // 검증끝나고 삭제

            return code.equals(storedCode);

        } catch (Exception e) {
            return false;
        }
    }

}

