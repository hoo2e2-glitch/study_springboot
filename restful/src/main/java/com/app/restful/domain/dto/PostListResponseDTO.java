package com.app.restful.domain.dto;

import com.app.restful.domain.vo.PostVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "게시판 조회")
public class PostListResponseDTO {
    // 게시판 전체/상세 목록 dto
    @Schema(description = "게시판 번호", example = "1")
    private Long id;
    @Schema(description = "게시판 제목", example = "제목")
    private String postTitle;
    @Schema(description = "게시판 내용", example = "내용")
    private String postContent;
    @Schema(description = "회원 번호", example = "1")
    private Long memberId;
    @Schema(description = "게시판 조회수", example = "10")
    private Long postReadCount;
    @Schema(description = "회원 이메일", example = "test@gmail.com")
    private String memberEmail;
    @Schema(description = "회원 이름", example = "kim")
    private String memberName;

}