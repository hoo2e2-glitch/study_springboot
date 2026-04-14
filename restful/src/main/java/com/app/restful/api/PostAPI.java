package com.app.restful.api;

import com.app.restful.domain.dto.MemberDTO;
import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
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
public class PostAPI {

    private final PostService postService;

    @GetMapping("")
    @Operation(summary = "게시판 목록 조회 서비스", description = "목록 조회" )
    @ApiResponse(responseCode = "200", description = "게시판 목록 조회")
    public List<PostDTO> postList(){
        return postService.findPost();
    }

    }



