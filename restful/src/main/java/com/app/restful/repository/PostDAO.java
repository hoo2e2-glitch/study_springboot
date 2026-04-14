package com.app.restful.repository;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.mapper.MemberMapper;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Optional 처리 -> 공식
@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

    public List<PostDTO> findPostList(){
        return postMapper.selectAll();

    }




}
