package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostMapper {

    //- 게시글 목록 조회 서비스
    public List<PostDTO> selectAll();
    //- 게시글 상세보기 조회 서비스
    public void selectById(Long id);




}
