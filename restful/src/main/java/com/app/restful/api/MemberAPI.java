package com.app.restful.api;

import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    // 회원 목록 조회 서비스
    @Operation(summary = "회원목록조회 서비스", description = "회원 목록을 조회해서 리스트로 변환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록을 조회해")
    @GetMapping("")
    public List<MemberResponseDTO> getMembers() {
        return memberService.getMemberList();
    }

    // 회원 정보 조회 서비스
    @Operation(summary = "회원단일조회 서비스", description = "회원 목록을 조회해서 리스트로 변환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록을 조회 성공")
    @Parameter(
            name = "id",
            description = "회원",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @GetMapping("/{id}")
    public MemberResponseDTO getMemberInfo(@PathVariable Long id){
        return  null;
    }

    // 회원 추가 서비스
    // id를 안받을꺼니까 이게 정석은 맞음
    @PostMapping("/join") // 개인정보 노출 x
    @Operation(summary = "회원가입 서비스", description = "회원 정보를 받아서 회원가입 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원 가입 성공")
    // @RequestBody 쓰는 이유 : fetch로 요청하면
    public void join(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO){
        memberService.join(memberJoinRequestDTO);
        }

        // 로그인
        @PostMapping("/login")
        @Operation(summary = "로그인 서비스", description = "아이디 비밀번호 검증 -> 서비스")
        @ApiResponse(responseCode = "200", description = "로그인 성공")
        public MemberResponseDTO login(@RequestBody MemberVO memberVO){
            return memberService.login(memberVO);
        }

        // 수정
        @PutMapping("/{id}")
        @Operation(summary = "회원정보 수정 서비스", description = "회원정보 업데이트 서비스")
        @ApiResponse(responseCode = "200", description = "회원정보 수정 성공")
        @Parameter(
                name = "id",
                description = "회원",
                required = true,
                in = ParameterIn.PATH,
                example = "1",
                schema = @Schema(type = "number") )// 스키마 타입
        public void updateMember(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO, @PathVariable Long id){
            memberUpdateRequestDTO.setId(id);
            memberService.updateMemberInfo(memberUpdateRequestDTO);
        }

        // 삭제
        @DeleteMapping("/withdraw")
        @Operation(summary = "회원삭제 서비스", description = "회원아이디를 받아서 회원탈퇴 서비스")
        @ApiResponse(responseCode = "204", description = "회원 탈퇴 성공")
        @Parameter(
                name = "id",
                description = "회원",
                required = true,
                in = ParameterIn.PATH,
                example = "1",
                schema = @Schema(type = "number") )// 스키마 타입
        public void  withdraw(@RequestBody Long id){
            memberService.deleteMemberInfo(id);
        }

    }



