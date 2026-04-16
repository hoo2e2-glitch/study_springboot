package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import com.app.restful.domain.vo.PostVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
@Schema(description = "게시글 수정 dto")
public class PostUpdateRequestDTO {
    // 게시판 수정 dto
    // id만 따로 넣음 -> 실무는
//    private Long id;
    @Schema(description = "게시글 제목", required = true, example = "수정된 게시글 제목1")
    private String postTitle;
    @Schema(description = "게시글 내용", required = true, example = "수정된 게시글 내용1")
    private String postContent;

}
