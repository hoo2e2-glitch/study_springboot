package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// test 전에 넣기
// 로그 객체 자동 생성
@Slf4j
// 스프링 부트 테스트용 어노테이션
@SpringBootTest
//스프링 빈 주입받아서 테스트하고
// 그 결과를 log.info()로 확인하려고
// 같이 자주 씁니다.
public class postMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest() {
        PostVO postVO = new PostVO();

        postVO.setPostTitle("타이틀3");
        postVO.setPostContent("내용2");
        postVO.setMemberId(3L);

        postMapper.insert(postVO);
        log.info(postVO.toString());
    }

    @Test
    public void selectAllTest(){
        postMapper.selectAll().stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        Long postId = 1L;
        postMapper.select(postId);
        log.info(postId.toString());

    }

    @Test
    public void selectByDescTest(){

        postMapper.selectByDesc().stream().map(PostVO::toString).forEach(log::info);

    }

    @Test
    public void updatePostReadCount(){
        PostVO postVO = new PostVO();
        postVO.setId(2L);
        postVO.setPostReadCount(1L);
        postMapper.updatePostReadCount(2L);
        log.info(postVO.toString());

    }





}
