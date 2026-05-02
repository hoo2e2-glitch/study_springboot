package com.app.oauth.api;

import com.app.oauth.domain.dto.request.VerificationRequestDTO;
import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
public class SmsApi {

    private final AuthService authService;

    // 핸드폰 전송 ->
    @PostMapping("/phone/verification-code")
    public ResponseEntity<ApiResponseDTO> sendMemberPhoneVerificationCode(@RequestBody VerificationRequestDTO verificationRequestDTO)
    {

        String memberPhone = verificationRequestDTO.getMemberPhone();
        ApiResponseDTO apiResponseDTO = null;
        if(authService.sendMemberPhoneVerificationCode(memberPhone)){
            apiResponseDTO = ApiResponseDTO.of(true,"메세지 발송됨");
        }else {
            apiResponseDTO = ApiResponseDTO.of(false, "휴대폰 번호를 확인");
        }

        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    // 휴대폰 인증코드 검증
    @PostMapping("/phone/verification-code/verify")
    public ResponseEntity<ApiResponseDTO> verifyMemberPhoneVerificationCode(@RequestBody VerificationRequestDTO verificationRequestDTO){

        String memberPhone = verificationRequestDTO.getMemberPhone();
        String code = verificationRequestDTO.getCode();
        ApiResponseDTO apiResponseDTO = null;

        if(authService.verifyMemberPhoneVerificationCode(memberPhone,code)){
            apiResponseDTO = ApiResponseDTO.of(true, "인증이 완료");
        }else {
            apiResponseDTO = ApiResponseDTO.of(false, "인증번호 확인");

        }
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }

    // 이메일 전송 ->
    @PostMapping("/email/verification-code")
    public ResponseEntity<ApiResponseDTO> sendMemberEmailVerificationCode(@RequestBody VerificationRequestDTO verificationRequestDTO){

        String memberEmail = verificationRequestDTO.getMemberEmail();
        ApiResponseDTO apiResponseDTO = null;
        if(authService.sendMemberEmailVerificationCode(memberEmail)){
            apiResponseDTO = ApiResponseDTO.of(true,"이메일 발송됨");
        }else {
            apiResponseDTO = ApiResponseDTO.of(false, "이메일 주소를 확인");
        }

        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);

    }

    // 이메일 인증코드 검증
    @PostMapping("/email/verification-code/verify")
    public ResponseEntity<ApiResponseDTO> verifyMemberEmailVerificationCode(@RequestBody VerificationRequestDTO verificationRequestDTO){

        String memberEmail = verificationRequestDTO.getMemberEmail();
        String code = verificationRequestDTO.getCode();
        ApiResponseDTO apiResponseDTO = null;

        if(authService.verifyMemberEmailVerificationCode(memberEmail,code)){

            apiResponseDTO = ApiResponseDTO.of(true, "인증이 완료");
        }else {
            apiResponseDTO = ApiResponseDTO.of(false, "인증번호 확인");

        }
        return ResponseEntity.status(HttpStatus.OK).body(apiResponseDTO);
    }


}
