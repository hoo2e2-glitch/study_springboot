package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest

public class postMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void selectAllTest(){
        List<PostVO> posts = postMapper.selectAll();
//        forEach는 “가져온 목록 하나씩 확인하기”
        posts.forEach(post -> log.info("{}",post));
    }

    @Test
    public void selectTest(){
        Optional<PostVO> posts = postMapper.select(2L);
        posts.ifPresent(post -> log.info("{}",post));

    }


}
