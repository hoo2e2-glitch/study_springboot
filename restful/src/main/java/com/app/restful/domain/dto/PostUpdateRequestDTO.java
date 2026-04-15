package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import com.app.restful.domain.vo.PostVO;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class PostUpdateRequestDTO {
    //게시판 수정 dto
    private Long id;
    private String postTitle;
    private String postContent;

}
