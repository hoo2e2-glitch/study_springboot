package com.app.controller.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
//2. VO 또는 DTO를 설계
public class PostUpdateDTO {

    private Long id;
    private String postTitle;
    private String postContent;
}