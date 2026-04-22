package com.app.oauth.repository;

import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// Optional 처리 -> 공식
@Repository
@RequiredArgsConstructor
public class MemberDAO {

    public final MemberMapper memberMapper;


    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    public Optional<MemberVO> findById(Long id){
//        oauthMemberMapper.selectById(id);
       return Optional.ofNullable(memberMapper.selectById(id));
    }

    public Optional<MemberVO> findByMemberEmail(String memberEmail){
        return Optional.ofNullable(memberMapper.selectByMemberEmail(memberEmail));
    }

    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

    public void delete(Long id) {
        memberMapper.delete(id);
    }
}
