package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SmsUtilTest {

    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void sendSmsTest() {
        smsUtil.sendOneMemberPhone("01093860238", "메세지 확인");

    }


}




