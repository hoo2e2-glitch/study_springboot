package com.app.ncs.api;


import com.app.ncs.domain.dto.ApiResponseDTO;
import com.app.ncs.domain.dto.MemberJoinRequestDTO;
import com.app.ncs.domain.dto.MemberResponseDTO;
import com.app.ncs.domain.dto.MemberUpdateRequestDTO;
import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.service.MemberService;
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/join")
    @Operation(summary = "회원가입 서비스", description = "회원 정보 받아서 가입")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    @ApiResponse(responseCode = "409", description = "이메일 중복")
    public ResponseEntity<ApiResponseDTO> joinMember(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO) {
        memberService.join(memberJoinRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDTO.of("회원가입 성공"));
    }

    // 로그인 email/password
    @PostMapping("/login")
    @Operation(summary = "로그인 서비스", description = "이메일/비밀번호 검증 후 로그인")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    @ApiResponse(responseCode = "401", description = "로그인 실패")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    public ResponseEntity<ApiResponseDTO> loginMember(@RequestBody MemberVO memberVO) {
        MemberResponseDTO foundMember = memberService.login(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("로그인 성공", foundMember));
    }

    // 회원 전체 조회
    @GetMapping("")
    @Operation(summary = "회원목록 조회 서비스", description = "회원 목록 조회 후 리스트로 반환")
    @ApiResponse(responseCode = "200", description = "회원목록 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원목록 조회 실패")
    public ResponseEntity<ApiResponseDTO> memberList() {
        List<MemberResponseDTO> foundMember = memberService.getMemberList();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 전체 조회 성공", foundMember));
    }

    // 회원 정보 조회 id
    @GetMapping("/{id}")
    @Operation(summary = "회원 단일 조회 서비스", description = "회원 조회해서 객채로 반환")
    @ApiResponse(responseCode = "200", description = "회원 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 조회 실패")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> memberId(@PathVariable Long id){
        MemberResponseDTO foundMember = memberService.getMemberId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 조회 성공", foundMember));
    }

    // 회원 정보 변경
    @PutMapping("/{id}")
    @Operation(summary = "회원 정보 수정 서비스", description = "회원 정보 업데이트")
    @ApiResponse(responseCode = "200", description = "회원 정보 수정 완료")
    @ApiResponse(responseCode = "400", description = "잘못된 접근")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> updateMember(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO, @PathVariable Long id) {
        memberUpdateRequestDTO.setId(id);
        memberService.updateMember(memberUpdateRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 수정 완료"));
    }

    // 회원 탈퇴
    @DeleteMapping("/{id}")
    @Operation(summary = "회원 탈퇴 서비스", description = "회원 아이디로 회원 탈퇴")
    @ApiResponse(responseCode = "204", description = "회원 탈퇴 완료")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            schema = @Schema(type = "number")
    )
    public ResponseEntity<ApiResponseDTO> memberDelete(@PathVariable Long id) {
        memberService.withdrawMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 탈퇴 완료"));
    }

}
