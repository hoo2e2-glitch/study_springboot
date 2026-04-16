package com.app.controller.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
//2. VO 또는 DTO를 설계
// 다른서버와 소통 이뤄지는 vo
public class PostVO implements Serializable {

    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;
}