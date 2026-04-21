package com.app.ncs.controller;

import com.app.ncs.domain.dto.ApiResponseDTO;
import com.app.ncs.exception.MemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// 예외가 터졋을 때 -> 에러 응답을 한 곳에서 대신 처리해주는 클래스
// : 서비스에서 예외가 터졌을 때
// -> CustomExceptionHandler 클래스가 그 예외를 대신 받아서 HTTP 에러 응답으로 바꿔주는 역할
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ApiResponseDTO> memberException(MemberException e) {
        return ResponseEntity.status(e.getStatus()).body(ApiResponseDTO.of(e.getMessage()));
    }

}
