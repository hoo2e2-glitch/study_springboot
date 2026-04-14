package com.app.restful.repository;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Optional 처리 -> 공식
@Repository
@RequiredArgsConstructor
public class MemberDAO {


    private final MemberMapper memberMapper;

    // 회원 추가
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    // 회원 이메일 유무 조회
    public int existMemberEmail(String memberEmail) {
        return memberMapper.existMemberEmail(memberEmail);
    }

    //단일 조회(id)
    public Optional<MemberVO> findById(Long id) {
        return Optional.ofNullable(memberMapper.selectById(id));
    }
    // 단일 조회(email/password)
    public Optional<MemberVO> findByEmail(MemberVO memberVO) {
        return Optional.ofNullable(memberMapper.select(memberVO));
    }
    // 전체 조회
    public List<MemberVO> findAll() {
        return memberMapper.selectAll();
    }
    // 회원정보 수정
    public void updateMember(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }
    // 수정 - 비밀번호

    // 삭제
    public void deleteMember(Long id) {
        memberMapper.delete(id);
    }


}
