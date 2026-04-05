package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class mapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Test
    public  void insertTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setId(4L);
        memberVO.setMemberEmail("testtest@gmail.com");
        memberVO.setMemberPassword("testtest321");
        memberVO.setMemberName("testkim");

        memberMapper.insert(memberVO);
    }

    @Test
    public void selectAllTest(){
        log.info("{}", memberMapper.selectAll());
    }

    @Test
    public void selectTest(){
        log.info("{}", memberMapper.select(1L));
    }

    @Test
    public void updateTest(){

        MemberVO memberVO = new MemberVO();
        memberVO.setId(1L);
        memberVO.setMemberName("홍길동수정");

        memberMapper.update(memberVO);
    }

    @Test
    public void deleteTest(){

        memberMapper.delete(4L);
    }



}
