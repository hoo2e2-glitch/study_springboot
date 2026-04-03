package com.app.mybatis.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PostResponseDTO {

    private Long totalPageCount;
    private Long totalPostCount;
    private List<PostDTO> posts;


}
