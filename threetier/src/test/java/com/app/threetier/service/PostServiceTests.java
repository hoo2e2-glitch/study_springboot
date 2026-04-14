package com.app.threetier.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PostServiceTests {

    // 업캐스팅 - 인터페이스
    @Autowired
    private PostService postService;

    @Test
    public void getPostTest() {
        log.info("post {}:", postService.getPosts());
    }

//    @Test
//    public void getPostByIdTest() {
//        log.info("post {}:", postService.getPost(6L));
//    }

    @Test
    public void deletePostByIdTest() {
        postService.deletePost(7L);
    }



}
