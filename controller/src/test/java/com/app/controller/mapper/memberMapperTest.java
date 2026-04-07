package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest

public class memberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void memberinsertTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("te454523@gmail.com");
        memberVO.setMemberPassword("11151511");
        memberVO.setMemberName("김김영이");

        memberMapper.insert(memberVO);
    }

    @Test
    public void select(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("te454523@gmail.com");
        memberVO.setMemberPassword("11151511");
        memberVO.setMemberName("김김영이");
        memberMapper.select(memberVO);

        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
        log.info("foundMember: {}", foundMember);

    }

    @Test
    public  void update(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberName("홍12");
        memberMapper.update(memberVO);

        log.info("memberVO: {}", memberVO);
    }

    @Test
    public   void delete(){
        MemberVO memberVO = new MemberVO();

        memberMapper.delete(22L);

        log.info("memberVO: {}", memberVO);

    }

}
