package com.app.controller.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
@Component
@Data
public class PostDTO {

    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;
    private String memberEmail;
    private String memberName;
}