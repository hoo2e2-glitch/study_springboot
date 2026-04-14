package com.app.mybatis.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
//DTO :
// 필요한 데이터만 담을 수 있음
// 조인결과 다루기 쉬움
// 유지보수 쉬움
public class PostDTO {

    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;
    private String memberEmail;
    private String memberName;
    private Long likeCount;
    private boolean isLiked;

}
