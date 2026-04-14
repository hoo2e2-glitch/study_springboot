package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Slf4j
public class mapperTest {

    @Autowired
    private TimeMapper timeMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberVO memberVO;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostVO postVO;


//    @Test
//    public void mapperTest(){
//        log.info(timeMapper.getTime());
//
//    }
//    @Test
//    public void mapperTest2(){
//        log.info(timeMapper.getTime2(););
//
//    }

    @Test
    public void mapperTest3() {
        log.info(memberMapper.selectAll().toString());
//        log.info("{}", memberMapper.selectAll());

    }

    @Test
    public void mapperTest4() {
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("tes785@gmail.com");
        memberVO.setMemberPassword("test0020@");
        memberVO.setMemberName("이씨");

        memberMapper.insert(memberVO);
    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(4L);
        memberVO.setMemberEmail("test00000@gmail.com");
        memberVO.setMemberPassword("tefd345@");
        memberVO.setMemberName("장보고이이");
        memberMapper.update(memberVO);
    }

    @Test
    public void deleteTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(4L);
        memberMapper.delete(memberVO);
    }


//    @Test
//    public void postInsert() {
//        PostVO postVO = new PostVO();
//
//        postVO.setPostTitle("글4");
//        postVO.setPostContent("내용4");
//        postVO.setMemberId("2");
//        postVO.setPostReadCount(8);
//
//        postMapper.insert(postVO);
//    }




}