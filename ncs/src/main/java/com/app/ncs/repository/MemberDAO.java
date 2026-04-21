package com.app.ncs.repository;


import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    // 회원가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    // 로그인 email/password
    public Optional<MemberVO> findByMemberEmailAndPassword(MemberVO memberVO) {
        return Optional.ofNullable(memberMapper.selectByMemberEmailAndPassword(memberVO));
    }

    // 회원 전체 조회
    public List<MemberVO> findAll() {
        return memberMapper.selectAll();
    }

    // 회원 정보 조회 id
    public Optional<MemberVO> findById(Long id) {
        return Optional.ofNullable(memberMapper.selectById(id));
    }

    // 이메일 중복 확인
    // Mapper/DAO = “숫자 전달자” -> DB 결과를 직접 다룸
    public int existMemberEmail(String memberEmail) {
        return memberMapper.existsByMemberEmail(memberEmail);
    }

    // 회원 정보 변경
    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

    // 회원 탈퇴
    public void delete(Long id) {
        memberMapper.delete(id);
    }

}
