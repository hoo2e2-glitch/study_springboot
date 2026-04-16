package com.app.restful.service;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
//9. Test(단위 테스트)
public class PostServiceTests {

    @Autowired
    PostService postService;
    @Autowired
    private PostDTO postDTO;

    //- 게시글 목록 조회 서비스
    @Test
    public void selectAllTest(){
//        PostDTO postDTO = new PostDTO();

//        postDTO.setPostTitle("제제목목");
//        postDTO.setPostContent("내내용용");
//        postDTO.setMemberId(6L);
//        postDTO.setPostContent(postDTO.getPostContent());
//        postDTO.setMemberName("kimmy");
//        postDTO.setMemberEmail("kim123@gmail.com");

        postService.getPostList("");
        log.info("{}",postService.getPostList(""));
    }
    //- 게시글 상세보기 조회 서비스
    @Test
    public void selectByIdTest(){
        log.info("{}",postService.getPostDetail(4L));
        postService.getPostDetail(4L);
    }
    //- 게시글 작성 서비스
    @Test
    public void writePostTest(){
        PostInsertRequestDTO postInsertRequestDTO = new PostInsertRequestDTO();

        postInsertRequestDTO.setPostTitle("신제목5");
        postInsertRequestDTO.setPostContent("신내용5");

        postService.writePost(postInsertRequestDTO,1L);
    }
    //- 게시글 수정 서비스
    @Test
    public void updatePostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();

        postUpdateRequestDTO.setPostTitle("제제");
        postUpdateRequestDTO.setPostContent("신신");

        postService.modifyPost(postUpdateRequestDTO,1L);
    }
    //- 게시글 삭제 서비스
    @Test
    public void deletePostTest(){
        postService.remove(4L);
    }
    //- 게시글 삭제(탈퇴시) 서비스
    @Test
    public void deleteByIdTest(){
        postService.deleteById(1L);
    }

}




