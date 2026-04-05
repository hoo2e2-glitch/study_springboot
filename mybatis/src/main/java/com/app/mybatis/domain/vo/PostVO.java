package com.app.mybatis.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

// spring에게 알리기
@Component
// getter/setter
@Data
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;

}

