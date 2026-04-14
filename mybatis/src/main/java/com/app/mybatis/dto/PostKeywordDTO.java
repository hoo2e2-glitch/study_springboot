package com.app.mybatis.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostKeywordDTO {

    private Long keywordPostTitle;
    private Long keywordPostContent;
}
