package com.app.controller.mapper;

import com.app.controller.domain.dto.PostDTO;
import com.app.controller.domain.dto.PostUpdateDTO;
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

    //- 게시글 목록 조회 서비스
    @Test
    public void selectAllTest(){
        List<PostDTO> posts = postMapper.selectAll();
//        forEach는 “가져온 목록 하나씩 확인하기”
        posts.forEach(post -> log.info("{}",post));
    }

    //- 게시글 상세보기 조회 서비스
    @Test
    public void selectTest(){
        Optional<PostDTO> posts = postMapper.select(29L);
        posts.ifPresent(post -> log.info("{}",post));
    }
    //- 게시글 작성 서비스
    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();

        postVO.setPostTitle("666666666");
        postVO.setPostContent("6666666666");
        postVO.setMemberId(21L);
        postVO.setPostReadCount(null);

        postMapper.insert(postVO);
        log.info("{}",postVO);
    }

    //- 게시글 수정 서비스
    @Test
    public void updateTest(){
        PostUpdateDTO postUpdateDTO = new PostUpdateDTO();

        postUpdateDTO.setId(38L);
        postUpdateDTO.setPostTitle("181181818");
        postUpdateDTO.setPostContent("881818181");

        postMapper.update(postUpdateDTO);
        log.info("{}",postUpdateDTO);

    }
    //- 게시글 삭제 서비스
    @Test
    public void deleteTest(){
        postMapper.delete(34L);
    }
    //- 게시글 삭제(탈퇴시) 서비스


}
