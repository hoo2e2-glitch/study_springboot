package com.app.restful.service;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostListResponseDTO;
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
    private PostListResponseDTO postListResponseDTO;

    //- 게시글 목록 조회 서비스
    @Test
    public void selectAllTest(){
//        PostListResponseDTO postDTO = new PostListResponseDTO();

//        postDTO.setPostTitle("제제목목");
//        postDTO.setPostContent("내내용용");
//        postDTO.setMemberId(6L);
//        postDTO.setPostContent(postDTO.getPostContent());
//        postDTO.setMemberName("kimmy");
//        postDTO.setMemberEmail("kim123@gmail.com");

        postService.findAll().forEach(System.out::println);
    }
    //- 게시글 상세보기 조회 서비스
    @Test
    public void selectByIdTest(){
        log.info("{}",postService.findById(4L));
        postService.findById(4L);
    }
    //- 게시글 작성 서비스
    @Test
    public void writePostTest(){
        PostInsertRequestDTO postInsertRequestDTO = new PostInsertRequestDTO();

        postInsertRequestDTO.setPostTitle("신제목5");
        postInsertRequestDTO.setPostContent("신내용5");
        postInsertRequestDTO.setPostReadCount(7L);
        postInsertRequestDTO.setMemberId(24L);

        postService.writePost(postInsertRequestDTO);
    }
    //- 게시글 수정 서비스
    @Test
    public void updatePostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();

        postUpdateRequestDTO.setPostContent("신신");
        postUpdateRequestDTO.setPostTitle("제제");
        postUpdateRequestDTO.setId(3L);

        postService.update(postUpdateRequestDTO);

    }
    //- 게시글 삭제 서비스
    @Test
    public void deletePostTest(){
        postService.delete(4L);
    }
    //- 게시글 삭제(탈퇴시) 서비스
    @Test
    public void deleteByIdTest(){
        postService.deleteById(1L);
    }

}




