package com.app.restful.excetion;

public class PostException extends  RuntimeException {
    public  PostException(){;}
    public PostException(String message) {
        super(message);
    }
}
