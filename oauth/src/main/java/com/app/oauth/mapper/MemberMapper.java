package com.app.oauth.mapper;

import com.app.oauth.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public void insert(MemberVO memberVO);

    public MemberVO selectById(Long id);

    public MemberVO selectByMemberEmail(String memberEmail);

    public void update(MemberVO memberVO);

    public void delete(Long id);





}
