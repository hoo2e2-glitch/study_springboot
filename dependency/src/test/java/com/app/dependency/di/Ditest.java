package com.app.dependency.di;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // test를 위한 클래스
@Slf4j // log에 결과를 출력
public class Ditest {
    // Test에서는 생성자 주입을 받을 수 없다.
    // 필드 주입
    @Autowired
    private Coding coding;

    @Autowired
    private Food food;

    @Autowired
    private Login login;


    @Test
    public void coningTest(){

        log.info("codingTest"); // 문자열만 출력가능
        log.info("coding : {}", coding.getComputer());

    }

    @Test
    public void FoodTest(){
        log.info("foodTest");
        log.info("food {}", food.getKnife());

    }

    @Test
    public void LoginTest(){
        log.info("loginTest");
        log.info("login {} ", login.getMember());
    }
//    @Test
//    public void MemberTest(){
//        log.info("memberTest");
//        log.info("member {}", member.getLogin());
//    }


}
