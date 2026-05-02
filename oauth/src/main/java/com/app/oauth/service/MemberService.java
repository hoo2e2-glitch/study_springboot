package com.app.oauth.service;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;


public interface MemberService {

    // 회원가입
    public ApiResponseDTO join(MemberDTO memberDTO);

    // 회원 정보 조회 <- 토큰
    public ApiResponseDTO me(Long id);

    // 마이페이지 - 회원 수정

    // 썸네일 수정
    public ApiResponseDTO updatePicture(MemberVO memberVO);

    // 회원 탈퇴

}
