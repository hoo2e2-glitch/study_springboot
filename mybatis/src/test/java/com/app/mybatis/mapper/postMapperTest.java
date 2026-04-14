package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.PostLikeVO;
import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.dto.PostCountDTO;
import com.app.mybatis.dto.PostDTO;
import com.app.mybatis.dto.PostResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootTest
@Slf4j
public class postMapperTest {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostLikeMapper postLikeMapper;

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("오늘 점심 뭐 먹지?");
        postVO.setPostContent("아무거나");
        postVO.setMemberId(1L);
        postMapper.insert(postVO);
    }

    @Test
    public void selectAllTest(){
        postMapper.selectAll(1L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        Long postId = 2L;
        PostVO postVO = new PostVO();
        postVO.setId(postId);
        postVO.setPostReadCount(1L);
        postMapper.updatePostReadCount(2L);
        postMapper.select(postId).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void updateTest(){
        PostVO postVO = new PostVO();
        postVO.setId(2L);
        postVO.setPostTitle("오늘 점심은 배터지게 드세요!!");
        postVO.setPostContent("아무거나");
        postVO.setMemberId(1L);

        postMapper.update(postVO);
        postMapper.select(2L).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest(){
        postMapper.delete(4L);
    }

    @Test
    public void postUpdateReadCountTest(){
        PostVO postVO = new PostVO();
        postVO.setId(2L);
        postVO.setPostReadCount(1L);
        postMapper.updatePostReadCount(2L);
    }

    @Test
    public void insertTest2(){

        for (int i = 0; i < 50; i++ ){
            PostVO postVO = new PostVO();
            postVO.setPostTitle("테스트게시글" + (i + 1));
            postVO.setPostContent("테스트게시글" + (i + 1));
            postVO.setMemberId(1L);

            postMapper.insert(postVO);
        }
    }
    @Test
    public void updateTest2() {
        Random random = new Random();
        random.nextInt(50);
        for (int i = 0; i < 5000; i++) {
            Long id = Long.valueOf(random.nextInt(50));
            postMapper.updatePostReadCount(id);
        }
    }

    @Test
    public void selectAllWithOrder(){

        Map<String,Object> orders = new HashMap<>();
        orders.put("order", "popular");
        orders.put("cursor", 1);
        orders.put("limit", 5);

        postMapper.selectAllWithOrder(orders)
                .stream()
                .map(PostDTO::toString)
                .forEach(log::info);
    }

    @Test
    public void selectTotalPostCountAndPageCount(){
        int limit = 10;
        PostCountDTO postCountDTO = postMapper.selectTotalPostCountAndPageCount(limit);
        log.info("postTotalCountDTO : {}", postCountDTO);
    }



    //    게시판 목록 조회
    @Test
    public void selectTotalPostCountAndPageCount2(){
        int limit = 10;

        Map<String,Object> orders = new HashMap<>();
        orders.put("order", "popular");
        orders.put("cursor", 1);
        orders.put("limit", 5);

        List<PostDTO> posts = postMapper.selectAllWithOrder(orders);
        PostCountDTO postCountDTO = postMapper.selectTotalPostCountAndPageCount(limit);

        /* 최종 응답 */
        PostResponseDTO postResponseDTO = new PostResponseDTO();

        postResponseDTO.setTotalPostCount(postCountDTO.getTotalPostCount());
        postResponseDTO.setTotalPageCount(postCountDTO.getTotalPageCount());
        postResponseDTO.setPosts(posts);


        postResponseDTO.setPosts(posts);

    }

    @Test
    public void selectAllWithKeywordTest2(){
        Map<String, Object> keywords = new HashMap<>();

        keywords.put("keyword", "테스트게시글5");

        postMapper.selectAllWithKeyword(keywords).stream().map(PostDTO::toString).forEach(log::info);

    }

    @Test
    public void postLikeTest(){
        PostLikeVO postLikeVO = new PostLikeVO();
//      1~50
        for (int i = 0; i < 50; i++ ) {
            Random random = new Random();
            int randomNumber = random.nextInt(1,51);
            postLikeVO.setMemberId(Long.valueOf(randomNumber));

            randomNumber = random.nextInt(1,4);
            postLikeVO.setPostId(Long.valueOf(randomNumber));
            postLikeMapper.insert(postLikeVO);
        }
    }

    @Test
    public void deleteWithPostLikeTest(){

        postLikeMapper.deleteWithPostLike(43L);
    }








}