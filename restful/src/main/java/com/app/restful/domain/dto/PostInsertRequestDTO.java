package com.app.restful.domain.dto;

import com.app.restful.domain.vo.PostVO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostInsertRequestDTO {
    // 게시판 등록 dto

    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;

    public static PostVO from(PostInsertRequestDTO postInsertRequestDTO){

        PostVO postVO = new PostVO();
        postVO.setPostTitle(postInsertRequestDTO.getPostTitle());
        postVO.setPostContent(postInsertRequestDTO.getPostContent());
        postVO.setMemberId(postInsertRequestDTO.getMemberId());
        postVO.setPostReadCount(postInsertRequestDTO.getPostReadCount());
        return postVO;
    }
}