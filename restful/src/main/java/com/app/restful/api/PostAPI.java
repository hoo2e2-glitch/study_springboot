package com.app.restful.api;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostListResponseDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 서비스호출
// 리턴값을 JSON으로 처리
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
//10. API(Rest)
public class PostAPI {

    private final PostService postService;

    //- 게시글 목록 조회 서비스
    @GetMapping("")
    @Operation(summary = "게시판 전체 목록 조회 서비스", description = "목록 조회" )
    @ApiResponse(responseCode = "200", description = "게시판 전체 목록 조회")
    public List<PostListResponseDTO> postList(){
        return postService.findAll();
    }

    //- 게시글 상세보기 조회 서비스
    @PostMapping("{id}")
    @Operation(summary = "게시판 상세 목록 조회 서비스", description = "상세 목록 조회 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시판 상세 목록 조회")
    @Parameter(
            name = "id",
            description = "게시판",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public PostListResponseDTO getPostList(@PathVariable Long id){
        return postService.findById(id);
    }

    //- 게시글 작성 서비스
    @PostMapping("/write")
    @Operation(summary = "게시글 작성 서비스", description = "게시글 작성 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시글 작성")
    public void writePost(@RequestBody PostInsertRequestDTO postInsertRequestDTO){
        postService.writePost(postInsertRequestDTO);
    }

    //- 게시글 수정 서비스
    @PutMapping("/{id}")
    @Operation(summary = "게시판 수정 서비스", description = "게시판 수정 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시판 수정")
    @Parameter(
            name = "id",
            description = "게시판",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public void updatePost(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO, @PathVariable Long id){
        postUpdateRequestDTO.setId(id);
        postService.update(postUpdateRequestDTO);
    }

    //- 게시글 삭제 서비스
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제 서비스", description = "게시글 삭제 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시판 삭제 완")
    @Parameter(
            name = "id",
            description = "게시판",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public void deletePost(@PathVariable Long id){
        postService.delete(id);
    }

    // {id} / {memberId} -> 같은 경로로 인식 // 확실하게 분리해줘야함
    //- 게시글 삭제(탈퇴시) 서비스
    @DeleteMapping("/{memberId}")
    @Operation(summary = "회원 탈퇴 시 게시글 삭제 서비스", description = "회원 탈퇴 시 게시글 삭제 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "회원탈퇴 및 게시글 삭제 완")
    @Parameter(
            name = "id",
            description = "게시판",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public void deleteMemberId(@PathVariable Long memberId){
        postService.deleteById(memberId);
    }

}





