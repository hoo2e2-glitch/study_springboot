package com.app.aop.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Integer.parseInt;

@Slf4j
@SpringBootTest
public class sampleServiceTest {

    @Autowired
    private sampleService sampleService;



    @Test
    public void  logStatus() {
        log.info("result : {}", sampleService.doAdd("ㄱ", "2"));

    }
}
