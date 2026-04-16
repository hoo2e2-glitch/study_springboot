package com.app.restful.domain.vo;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
//2. VO 또는 DTO를 설계
public class PostVO implements Serializable {

    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;

    // 정적 팩토리 메서드 / id값으 set 으로
    public static PostVO from(PostInsertRequestDTO postInsertRequestDTO){
        PostVO postVO = new PostVO();

        postVO.setPostTitle(postInsertRequestDTO.getPostTitle());
        postVO.setPostContent(postInsertRequestDTO.getPostContent());
        return postVO;
    }

    public static PostVO from(PostUpdateRequestDTO postUpdateRequestDTO){
        PostVO postVO = new PostVO();

        postVO.setPostTitle(postUpdateRequestDTO.getPostTitle());
        postVO.setPostContent(postUpdateRequestDTO.getPostContent());
        return postVO;
    }
}