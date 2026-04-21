package com.app.ncs.domain.dto;

import com.app.ncs.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Schema(description = "회원정보 응답 DTO")
// ResponseDTO = 서버가 사용자(클라이언트)에게 돌려주는 값
// ResponseDTO = 응답 / 나가는 데이터
// 서버가 응답함: 회원번호, 이메일, 이름, 가입완료메시지 / id, email, name
public class MemberResponseDTO {

    @Schema(description = "회원 번호", example = "1", required = true)
    private Long id;
    @Schema(description = "회원 이메일", example = "111@gmail.com", required = true)
    private String memberEmail;
    @Schema(description = "이름", example = "김이박")
    private String memberName;

    // VO -> ResponseDTO
    // ResponseDTO는 보통 VO -> ResponseDTO 변환 메서드 작성
    // 조회한 내부 데이터를 밖으로 응답용 객체로 바꾸는 흐름
    public static MemberResponseDTO from(MemberVO memberVO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();

        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        return memberResponseDTO;
    }
}
