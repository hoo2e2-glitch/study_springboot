package com.app.restful.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "게시판 dto")
public class PostDTO {
    // 게시판 전체/상세 목록 dto
    @Schema(description = "게시글 번호", example = "1",  required = true)
    private Long id;
    @Schema(description = "게시글 제목", example = "제목",   required = true)
    private String postTitle;
    @Schema(description = "게시글 내용", example = "내용", required = true)
    private String postContent;
    @Schema(description = "회원 번호", example = "1",  required = true)
    private Long memberId;
    @Schema(description = "게시글 조회수", example = "10")
    private Long postReadCount;
    @Schema(description = "회원 이메일", example = "test@gmail.com",  required = true)
    private String memberEmail;
    @Schema(description = "회원 이름", example = "kim")
    private String memberName;

}