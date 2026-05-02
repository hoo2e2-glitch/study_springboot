package com.app.oauth.mapper;

import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

    // 회원추가
    public void insert(MemberVO memberVO);

    // 회원조회 id
    public MemberDTO select(Long id);

    // 회원 조회 email
    public MemberDTO selectByMemberEmailAndSocialMemberProvider(MemberDTO memberDTO);

    // 회원가입 여부 email
    public boolean existMemberByEmailAndSocialMemberProvider(MemberDTO memberDTO);

    // 회원 수정
    public void update(MemberVO memberVO);

    // 썸네일 변경
    public void updatePicture(MemberVO memberVO);
    // 회원 삭제
    public void delete(Long id);





}
