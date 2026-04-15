package com.app.restful.mapper;

import com.app.restful.domain.dto.PostListResponseDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
//5. Mapper 인터페이스(xml의 id와 메서드의 이름이 동일)
public interface PostMapper {

    //- 게시글 목록 조회 서비스
    public List<PostListResponseDTO> selectAll();
    //- 게시글 상세보기 조회 서비스
    public PostListResponseDTO selectById(Long id);
    //- 게시글 작성 서비스
    public void insert(PostVO postVO);
    //- 게시글 수정 서비스
    public void update(PostVO postVO);
    //- 게시글 삭제 서비스
    public void delete(Long id);
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteByMemberId(Long memberId);





}
