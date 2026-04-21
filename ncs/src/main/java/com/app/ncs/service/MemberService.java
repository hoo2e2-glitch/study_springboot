package com.app.ncs.service;

import com.app.ncs.domain.dto.MemberJoinRequestDTO;
import com.app.ncs.domain.dto.MemberResponseDTO;
import com.app.ncs.domain.dto.MemberUpdateRequestDTO;
import com.app.ncs.domain.vo.MemberVO;

import java.util.List;

public interface MemberService {
    // 알맞는 dto 만들기

    // 회원가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

    // 로그인 email/password
    public MemberResponseDTO login(MemberVO memberVO);

    // 회원 전체 조회
    public List<MemberResponseDTO> getMemberList();

    // 회원 정보 조회 id
    public MemberResponseDTO getMemberId(Long id);

    // 이메일 중복 확인
    // Service에서 void인 이유: 중복 여부를 검사하고 예외 처리하는 역할이기 때문
    // -> 그래서 반환값이 굳이 필요 없음
    // Service는 “중복이다/아니다 판단자” -> 결과를 비즈니스 의미로 해석
    public void checkMemberEmailDuplicate(String memberEmail);

    // 회원 정보 변경
    public void updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO);

    // 회원 탈퇴
    public void withdrawMember(Long id);

}
