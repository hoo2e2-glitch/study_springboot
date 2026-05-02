package com.app.oauth.util;

import com.app.oauth.domain.dto.MemberDTO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
public class JwtTokenUtilServiceTests {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void generateToken() {

        Map<String, String> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("memberEmail", "aaa@gmail.com");

        String accessToken = jwtTokenUtil.generateAccessToken(claims);
        String refreshToken = jwtTokenUtil.generateRefreshToken(claims);
        log.info("accessToken: {}", accessToken);
        log.info("refreshToken: {}", refreshToken);
    }

    @Test
    public void parseTokenTest() {
        Map<String, String> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("memberEmail", "aaa@gmail.com");
        String accessToken = jwtTokenUtil.generateAccessToken(claims);

        Claims parseClaims = jwtTokenUtil.parseToken("이규학");
        log.info("parseClaims: {}", parseClaims);
    }

    @Test
    public void vaildateTokenTest() {
        Map<String, String> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("memberEmail", "aaa@gmail.com");
        String accessToken = jwtTokenUtil.generateAccessToken(claims);

        log.info("{}", jwtTokenUtil.validateToken(accessToken));

    }

    @Test
    public void loginTokenTest() {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberEmail("aaa@gmail.com");
        memberDTO.setMemberPassword("1234");
        memberDTO.setMemberName("111");
        memberDTO.setMemberNickname("111");


    }

}




