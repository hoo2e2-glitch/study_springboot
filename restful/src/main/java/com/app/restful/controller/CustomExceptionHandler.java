package com.app.restful.controller;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.excetion.MemberException;
import com.app.restful.excetion.PostException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomExceptionHandler {
    // 여기서는 분기처리 불가능
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ApiResponseDTO> postException(PostException e) {
        return ResponseEntity.status(e.getStatus()).body(ApiResponseDTO.of(e.getMessage()));
      // return e.getMessage();
    }

    // 분기처리
    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ApiResponseDTO> memberException(MemberException e) {
        return ResponseEntity.status(e.getStatus()).body(ApiResponseDTO.of(e.getMessage()));
    }




}
