package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiResponse(responseCode = "200", description = "회원 목록을 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 조회 실패")
    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getMembers() {
        List<MemberResponseDTO> memberList = memberService.getMemberList();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 전체 조회 성공", memberList));
    }

    // 회원 정보 조회 서비스
    @Operation(summary = "회원단일조회 서비스", description = "회원 목록을 조회해서 리스트로 변환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록을 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 목록 조회 실패")
    @Parameter(
            name = "id",
            description = "회원",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getMemberInfo(@PathVariable Long id){
        MemberResponseDTO foundMember = memberService.getMemberInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 조회 서비스", foundMember));
    }

    // 회원 추가 서비스
    // id를 안받을꺼니까 이게 정석은 맞음
    @PostMapping("/join") // 개인정보 노출 x
    @Operation(summary = "회원가입 서비스", description = "회원 정보를 받아서 회원가입 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원 가입 성공")
    @ApiResponse(responseCode = "409", description = "이메일 중복")
    // @RequestBody 쓰는 이유 : fetch로 요청하면
    public ResponseEntity<ApiResponseDTO> join(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO){
        memberService.join(memberJoinRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("회원 가입 성공"));
    }

    // 로그인
    @PostMapping("/login")
    @Operation(summary = "로그인 서비스", description = "아이디 비밀번호 검증 -> 서비스")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    @ApiResponse(responseCode = "401", description = "로그인 실패")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody MemberVO memberVO){
        MemberResponseDTO loginMember = memberService.login(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("로그인 성공", loginMember));
    }

    // 수정
    @PutMapping("/{id}")
    @Operation(summary = "회원정보 수정 서비스", description = "회원정보 업데이트 서비스")
    @ApiResponse(responseCode = "200", description = "회원정보 수정 성공")
    @ApiResponse(responseCode = "400", description = "잘못된 접근")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") )// 스키마 타입
    public ResponseEntity<ApiResponseDTO> updateMember(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO, @PathVariable Long id){
        memberUpdateRequestDTO.setId(id);
        memberService.updateMember(memberUpdateRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 수정 완료"));
    }

    // 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴 서비스", description = "회원아이디를 받아서 회원탈퇴 서비스")
    @ApiResponse(responseCode = "200", description = "회원 탈퇴 성공")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") )// 스키마 타입
    public ResponseEntity<ApiResponseDTO> withdraw(@PathVariable Long id){
        memberService.withdraw(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 탈퇴 완료"));
    }

}



