package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
@Schema(description = "회원 정보 수정 dto")
public class MemberUpdateRequestDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기

    @Schema(description = "회원번호", required = true, example = "1")
    private Long id;
    @Schema(description = "비밀번호", required = true, example = "1234")
    private String memberPassword;
    @Schema(description = "이름", required = true, example = "홍")
    private String memberName;

}
