package com.app.ncs.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
// 내가 원하는 메시지 + 내가 원하는 상태코드를 담아서 던지려고 만든 거
// 회원가입/로그인/중복검사 같은 데서 쓰려고 만든 “커스텀 예외”
// 쉽게 비유하면 이 클래스는: 에러 택배 상자
//안에 담기는 것: 에러 설명문, HTTP 상태코드
public class MemberException extends RuntimeException {

    private HttpStatus status;

    public MemberException(){;}
    public MemberException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
