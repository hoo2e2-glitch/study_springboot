package com.app.ncs.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Schema(description = "회원가입 DTO")
// RequestDTO = 사용자(클라이언트)가 서버로 보내는 값
// RequestDTO = 요청 / 들어오는 데이터
//사용자가 보냄: 이메일, 비밀번호, 이름 / email, password, name
public class MemberJoinRequestDTO {

    @Schema(description = "회원 이메일", example = "111@gmail.com", required = true)
    private String memberEmail;
    @Schema(description = "비밀번호", example = "1234", required = true)
    private String memberPassword;
    @Schema(description = "이름", example = "김이박")
    private String memberName;
}
