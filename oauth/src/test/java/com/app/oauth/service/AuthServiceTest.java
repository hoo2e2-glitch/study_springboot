package com.app.oauth.service;

import com.app.oauth.util.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void sendMemberPhoneCodeTest(){
        authService.sendMemberPhoneVerificationCode("01047099813");
    }

    @Test
    public void verifyMemberPhoneCodeTest(){
        log.info("{}", authService.verifyMemberPhoneVerificationCode("01047099813", "821618"));
    }



}




