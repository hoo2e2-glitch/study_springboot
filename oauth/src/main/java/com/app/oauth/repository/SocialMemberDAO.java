package com.app.oauth.repository;

import com.app.oauth.domain.vo.SocialMemberVO;
import com.app.oauth.mapper.SocialMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



// Optional 처리 -> 공식
@Repository
@RequiredArgsConstructor
public class SocialMemberDAO {

    private final SocialMemberMapper socialMemberMapper;

    // social 회원 추가
    public void save(SocialMemberVO socialMemberVO){
        socialMemberMapper.insert(socialMemberVO);
    }

}
