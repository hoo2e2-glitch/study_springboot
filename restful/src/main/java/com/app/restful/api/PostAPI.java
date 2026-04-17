package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
//10. API(Rest)
public class PostAPI {

    private final PostService postService;

    //- 게시글 목록 조회 서비스
    @GetMapping("")
    @Operation(summary = "게시판 전체 목록", description = "게시판 목록을 조회하는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시판 전체 목록 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시판 조회 실패")
    @Parameter(
            name = "order",
            description = "게시판 정렬 처리하는 파라미터",
            required = true,
            in = ParameterIn.QUERY, // 쿼리로 들어옴
            schema = @Schema(type = "string")
    )
    // 이제 api에서 모두 ResponseEntity<ApiResponseDTO> return 해준다.
    public ResponseEntity<ApiResponseDTO> postList(
            @RequestParam(value = "order", defaultValue = "desc") String order
    ){
//        return postService.getPostList(order);
        List<PostDTO> postList = postService.getPostList(order);
        // .status : 상태코드 -> mdn 상태코드
        // .body : 응답데이터 -> ApiResponseDTO
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시판목록 조회 성공", postList));
//        return ApiResponseDTO.of("게시판목록 조회 목록", postList);
    }

    //- 게시글 상세보기 조회 서비스
    @GetMapping("/{id}")
    @Operation(summary = "게시판 상세보기", description = "해당 번호의 게시글 내용을 상세하게 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시글 조회 성공")
    @ApiResponse(responseCode = "404", description = "게시글 조회 실패")
    @Parameter(
            name = "id",
            description = "게시글의 번호",
            required = true,
            in = ParameterIn.PATH, // 쿼리로 들어옴
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> getPostList(@PathVariable Long id){
//        return postService.findById(id);
        PostDTO postDetail = postService.getPostDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시물 조회 완료", postDetail));
    }

    //- 게시글 작성 서비스
    @PostMapping("/")
    @Operation(summary = "게시글 추가", description = "게시글 작성 후 추가하고 보여주는 서비스" )
    @ApiResponse(responseCode = "201", description = "게시글 작성 성공")
    @ApiResponse(responseCode = "400", description = "게시글 작성 실패")
    public ResponseEntity<ApiResponseDTO> writePost(@RequestBody PostInsertRequestDTO postInsertRequestDTO){
        // memberId는 임의로 넣어둔 값 - 원래는 토큰으로 넣음
        // postService.writePost(postInsertRequestDTO, 1L);
        postService.writePost(postInsertRequestDTO, 1L);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("게시글 작성 성공"));
    }

    //- 게시글 수정 서비스
    @PutMapping("/{id}")
    @Operation(summary = "게시판 수정", description = "해당 번호의 게시글 내용을 변경해주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시글 수정 완료")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "id",
            description = "게시판 번호",
            required = true,
            in = ParameterIn.PATH,
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> updatePost(@RequestBody PostUpdateRequestDTO postUpdateRequestDTO, @PathVariable Long id){
        postService.modifyPost(postUpdateRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 수정 완료"));
    }

    //- 게시글 삭제 서비스
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 삭제 후 보여주는 서비스" )
    @ApiResponse(responseCode = "200", description = "게시글 삭제 완료")
    @ApiResponse(responseCode = "404", description = "게시글 없음")
    @Parameter(
            name = "id",
            description = "게시글의 번호",
            required = true,
            in = ParameterIn.PATH,
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> deletePost(@PathVariable Long id){
        postService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("게시글 삭제"));
    }

    // {id} / {memberId} -> 같은 경로로 인식 // 확실하게 분리해줘야함
    //- 게시글 삭제(탈퇴시) 서비스
//    public void deleteMemberId(@PathVariable Long memberId){
//        postService.deleteById(memberId);
//    }

}





