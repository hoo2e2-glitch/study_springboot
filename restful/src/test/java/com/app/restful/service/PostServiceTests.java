package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class PostServiceTests {

    @Autowired
    PostService postService;
    @Autowired
    private PostDTO postDTO;

    @Test
    public void selectAllTest(){
//        PostDTO postDTO = new PostDTO();

//        postDTO.setPostTitle("제제목목");
//        postDTO.setPostContent("내내용용");
//        postDTO.setMemberId(6L);
//        postDTO.setPostContent(postDTO.getPostContent());
//        postDTO.setMemberName("kimmy");
//        postDTO.setMemberEmail("kim123@gmail.com");

        postService.findPost().forEach(System.out::println);

    }

}




