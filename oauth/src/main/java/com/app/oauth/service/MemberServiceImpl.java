package com.app.oauth.service;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.domain.dto.JwtTokenDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.dto.response.MemberResponseDTO;
import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.domain.vo.SocialMemberVO;
import com.app.oauth.exception.MemberException;
import com.app.oauth.repository.MemberDAO;
import com.app.oauth.repository.SocialMemberDAO;
import com.app.oauth.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(rollbackFor = {Exception.class})
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService {

    // 생성자 주입
    private final MemberDAO memberDAO;
    private final SocialMemberDAO socialMemberDAO;
    private final PasswordEncoder passwordEncoder;

    // 회원 가입 서비스
    @Override
    public ApiResponseDTO join(MemberDTO memberDTO) {
        // 타입검증 / map은 못함
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();

        // / map은 못함
//        Map<String, Object> result = new HashMap<>();
        Map<String, Object> claims = new HashMap<>();

        // 1. 중복 여부 검사
        // 중복된 값이 있으면 -> throw
        if(memberDAO.existByEmail(memberDTO)){
            throw new MemberException("중복된 이메일", HttpStatus.BAD_REQUEST);
        }

        MemberVO memberVO = MemberVO.from(memberDTO);
        SocialMemberVO socialMemberVO = SocialMemberVO.from(memberDTO);

        // if(socialMemberVO.getSocialMemberProvider().equals("local")){ -> npe 발생
        if("local".equals(socialMemberVO.getSocialMemberProvider())){
            memberVO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        }

        memberDAO.save(memberVO);
        socialMemberVO.setMemberId(memberVO.getId());

        socialMemberDAO.save(socialMemberVO);

        claims.put("id", memberVO.getId());
        claims.put("email", memberVO.getMemberEmail());
        claims.put("memberProvider", socialMemberVO.getSocialMemberProvider());

        apiResponseDTO.setSuccess(true);
        apiResponseDTO.setMessage("회원가입완료");
        apiResponseDTO.setData(claims);

        // 회원 가입 후 로그인 페이지 -> 메세지 반환
        return apiResponseDTO;
    }

    // - 소셜
    public void socialLogin(MemberDTO memberDTO) {

    }

    // 토근으로 회원정보를 조회하는 서비스
    public ApiResponseDTO me(Long id) {
        MemberDTO foundMember = memberDAO.findByMemberId(id).orElseThrow(() -> {
            throw new MemberException("me회원 조회 실패", HttpStatus.BAD_REQUEST);
        });

        MemberResponseDTO memberResponseDTO = new MemberResponseDTO().from(foundMember);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "회원 조회 성공", memberResponseDTO);

        return apiResponseDTO;
    }

    // 썸네일 변경
    @Override
    public ApiResponseDTO updatePicture(MemberVO memberVO) {
        Map<String, Object> datas = new HashMap<>();

        memberDAO.updatePicture(memberVO);
        datas.put("updatedMemberPictureUrl", memberVO.getMemberPicture());
//        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "사진 변경 완료", datas);

        return ApiResponseDTO.of(true, "사진 변경 완료", datas);
    }
}

