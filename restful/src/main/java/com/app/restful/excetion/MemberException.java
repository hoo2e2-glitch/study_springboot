package com.app.restful.excetion;

public class MemberException extends RuntimeException {

    public MemberException() {;}
    public MemberException(String message) {
        super(message);
    }
}
