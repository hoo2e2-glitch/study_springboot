package com.app.ncs.mapper;

import com.app.ncs.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    // 회원가입
    public void insert(MemberVO memberVO);

    // 로그인 // optional
    public MemberVO selectByMemberEmailAndPassword(MemberVO memberVO);

    // 회원 전체 조회
    public List<MemberVO> selectAll();

    // 회원 정보 조회 // optional
    public MemberVO selectById(Long id);

    // 이메일 중복 확인
    public int existsByMemberEmail(String memberEmail);

    // 회원 정보 변경
    public void update(MemberVO memberVO);

    // 회원 탈퇴
    public void delete(Long id);
}
