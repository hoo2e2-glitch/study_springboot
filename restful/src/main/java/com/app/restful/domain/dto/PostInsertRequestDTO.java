package com.app.restful.domain.dto;

import com.app.restful.domain.vo.PostVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "게시판 생성 dto")
public class PostInsertRequestDTO {
    // 게시판 등록 dto
    @Schema(description = "게시글 제목", required = true, example = "게시글 제목1")
    private String postTitle;
    @Schema(description = "게시글 내용", required = true, example = "게시글 내용1")
    private String postContent;
    // 화면에서 memberid 안넘김 -> 나중에 토큰에서 추출
//    private Long memberId;
}