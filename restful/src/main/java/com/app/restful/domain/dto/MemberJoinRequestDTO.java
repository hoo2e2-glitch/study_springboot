package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
@Schema(description = "회원가입 dto")
public class MemberJoinRequestDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기
@Schema(description = "회원이메일", example = "dfd@gmail.com", readOnly = true)
    private String memberEmail;
@Schema(description = "비밀번호", example = "1234", readOnly = true)
    private  String memberPassword;
@Schema(description = "회원이름", example = "홍길동")
    private String memberName;

}
