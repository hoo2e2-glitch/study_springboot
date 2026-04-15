package com.app.restful.service;


import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    // dao = service : 무조건 1:1 매칭은 아님 / 제공하는 서비스에 따라 다름

    // 회원가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

    // 이메일 중복 확인
    public void checkMemberEmailDuplicate(String memberEmail);

    // 로그인
    public MemberResponseDTO login(MemberVO memberVO);

    // 회원 정보 조회
    public MemberResponseDTO getMemberInfo(Long id);

    // 회원 전체 조회
    public List<MemberResponseDTO> getMemberList();

    // 회원 수정 - 회원 정보 변경

    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO);


    // 회원 수정 - 비밀번호(마이페이지)
    // 회원 수정 - 비밀번호(로그인전)
    // 회원 탈퇴
    public void deleteMemberInfo(Long id);

}
