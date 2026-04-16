package com.app.controller.mapper;

import com.app.controller.domain.dto.PostDTO;
import com.app.controller.domain.dto.PostUpdateDTO;
import com.app.controller.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    //- 게시글 전체목록 조회 서비스
    public List<PostDTO> selectAll();
    //- 게시글 상세보기 조회 서비스
    public Optional<PostDTO> select(Long id);
    //- 게시글 작성 서비스
    public void insert(PostVO postVO);
    //- 게시글 수정 서비스
    public void update(PostUpdateDTO postUpdateDTO);
    //- 게시글 삭제 서비스
    public void delete(Long id);
    //- 게시글 삭제(탈퇴시) 서비스

}
