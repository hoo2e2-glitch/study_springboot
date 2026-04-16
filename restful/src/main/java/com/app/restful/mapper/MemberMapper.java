package com.app.restful.mapper;

import com.app.restful.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper { // 멤버할일들

    // 회원추가
    public void insert(MemberVO memberVO);
    // 회원 이메일 유무 조회
    public int existMemberEmail(String memberEmail);
    // 전체조회
    public List<MemberVO> selectAll();
    // 회원 단일 조회(id)
    public MemberVO selectById(Long id);
    // 회원 단일 조회(email/password)
    public MemberVO selectByMemberEmailAndMemberPassword(MemberVO memberVO);
    // 수정
    public void update(MemberVO memberVO);
    // 수정 - 비밀번호
    // 삭제
    public void delete(Long id);
}
