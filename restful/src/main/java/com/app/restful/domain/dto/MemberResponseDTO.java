package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
@Schema(description = "회원정보")
public class MemberResponseDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기

    @Schema(description = "회원번호", required = true, example = "1")
    private Long id;
    @Schema(description = "회원이메일", required = true, example = "resr@gmail.com")
    private String memberEmail;
    @Schema(description = "회원이름", example = "홍")
    private String memberName;

    // 정적 팩토리 메서드
    public static MemberResponseDTO from(MemberVO memberVO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();

        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        return memberResponseDTO;
    }

}
