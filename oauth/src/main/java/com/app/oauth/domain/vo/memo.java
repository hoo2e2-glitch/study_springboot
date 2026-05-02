//<!--if도 사용가능-->
//<!--    <insert id="insert" parameterType="MemberVO">
//        <selectKey keyProperty="id" order="BEFORE" resultType="Long">
//SELECT SEQ_OAUTH_MEMBER.NEXTVAL FROM DUAL
//        </selectKey>
//INSERT INTO TBL_OAUTH_MEMBER
//VALUES (
//        #{id},
//        #{memberEmail},
//            <choose>
//                <when test="memberPassword != null">#{memberPassword}</when>
//                <otherwise>NULL</otherwise>
//            </choose>,
//            <choose>
//                <when test="memberPicture != null">#{memberPicture}</when>
//                <otherwise>DEFAULT</otherwise>
//            </choose>,
//        #{memberName},
//        #{memberNickname},
//            <choose>
//                <when test="memberProvider != null">#{memberProvider}</when>
//                <otherwise>DEFAULT</otherwise>
//            </choose>
//        )
//    </insert>-->
//
//<!--    <select id="selectAll" resultType="MemberVO">-->
//<!--        SELECT ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_PICTURE, MEMBER_NAME, MEMBER_NICKNAME, MEMBER_PROVIDER-->
//<!--        FROM TBL_OAUTH_MEMBER-->
//<!--    </select>-->

//<select id="selectById" parameterType="Long" resultType="MemberVO">
//        SELECT ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_PICTURE, MEMBER_NAME, MEMBER_NICKNAME, MEMBER_PROVIDER
//FROM TBL_MEMBER
//WHERE ID = #{id}
//    </select>
//
//    <select id="selectByMemberEmail" parameterType="String" resultType="MemberVO">
//        SELECT ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_PICTURE, MEMBER_NAME, MEMBER_NICKNAME, MEMBER_PROVIDER
//FROM TBL_MEMBER
//WHERE MEMBER_EMAIL = #{memberEmail}
//    </select>
//
//    <update id="update" parameterType="MemberVO">
//UPDATE TBL_OAUTH_MEMBER
//SET MEMBER_NICKNAME = #{memberNickname}
//WHERE ID = #{id}
//    </update>
//
//    <delete id="delete" parameterType="Long">
//DELETE FROM TBL_OAUTH_MEMBER
//WHERE ID = #{id}
//    </delete>

//import com.app.oauth.domain.dto.MemberDTO;
//import com.app.oauth.domain.vo.MemberVO;
//import com.app.oauth.domain.vo.SocialMemberVO;
//import com.app.oauth.repository.MemberDAO;
//import com.app.oauth.repository.SocialMemberDAO;
//import com.app.oauth.service.MemberService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MemberServiceImpl implements MemberService {
//
//    // 생성자 주입
//    private final MemberDAO memberDAO;
//    private final SocialMemberDAO socialMemberDAO;
//    private final PasswordEncoder passwordEncoder;
//
//    // 회원 가입 서비스
//    @Override
//    public Map<String, Object> join(MemberDTO memberDTO) {
//
//        Map<String, Object> result = new HashMap<>();
//        Map<String, Object> claim = new HashMap<>();
//
//        // 1. 중복 여부 검사
//        // 중복된 값이 있으면 -> throw
//        if(memberDAO.existByEmail(memberDTO.getMemberEmail())){
//            throw new RuntimeException("중복된 이메일");
//        }
//
//        // 중복된 값이 없으면 서비스처리
//        // 2. 비밀번호 암호화(단반향)
//        // 소셜 회원가입시 비밀번호 없음
//        // 로컬 회원가입만 비밀번호를 가지고 있음
//        MemberVO memberVO = MemberVO.from(memberDTO);
//
//        // save -> selectkey ->
//        memberDAO.save(memberVO);
//        memberDTO.setMemberId(memberVO.getId());
//
//        SocialMemberVO socialMemberVO = SocialMemberVO.from(memberDTO);
//
//        if(socialMemberVO.getSocialMemberProvider().equals("lacal")){
//            memberVO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
//            // passwordEncoder.encode(memberDTO.getMemberPassword());
//        }
//
//        // 3. DB에 회원 추가
//        // dto -> mambervo
//        // dto -> socialmembervo
//        // insert 처리(트랜젝션 처리) throw
//
//        socialMemberDAO.save(socialMemberVO);
//
//        // 4. customexception 처리
//        // 5. 리턴여부 확인
//        result.put("success", true);
//        result.put("message", "회원가입완료");
//
//        claim.put("id", memberVO.getId());
//        claim.put("email", memberVO.getMemberEmail());
//        claim.put("provider", socialMemberVO.getSocialMemberProvider());
//
//        result.put("claim", claim);
//
//        // 회원 가입 후 로그인 페이지 -> 메세지 반환
//        return result;
//    }
//}

// MemberApi : 로그인 -> 순수데이터 응답 TokenDTO
// 방법 1. ApiResponseDTO 설계해서 응답
// -> 컨트롤러 쪽에서 Token 쿠키에 심고 -> 쿠기 제거 후 응답

// 방법 2. JwtTokenDTO 설계해서 응답 후 -> 받은 토큰을 쿠기에 심고
// -> 컨트롤러에서 ApiResponseDTO 설계

// react -> app.js

//app 첫번째 fetch
//1. accessToken -> 사용자의 정보 요청
//
//첫 번째 fetch 오류 catch 부분
//2. accessToken 만료 -> refreshToken(accessToken 갱신)
//두 번째 fetch 요청
//3. refreshToken과 accessToken -> 백엔드 서버("api/auth/refresh")
//4. refreshToken 내가 발급한게 맞는지 검증
//5. 새로운 accessToken을 발급 -> 프론트의 쿠키로 보냄
//6. 새로운 accessToken으로 -> 사용자의 정보를 재요청
//
//두 번째 fetch의 catch문
//4 -> refreshToken 만료 -> 로그아웃 처리 -> 재로그인

