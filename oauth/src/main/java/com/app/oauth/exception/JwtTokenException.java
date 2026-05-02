package com.app.oauth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenException extends RuntimeException {

    private HttpStatus httpStatus;

    public JwtTokenException(String message) {
        super(message);
    }
    public JwtTokenException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
