package com.app.restful.service;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;

import java.util.List;

//7. Service 인터페이스(확장성)
public interface PostService {

    //- 게시글 목록 조회 서비스 String order
    public List<PostDTO> getPostList(String order);
    //- 게시글 상세보기 조회 서비스
    public PostDTO getPostDetail(Long id);
    //- 게시글 작성 서비스
    public void writePost(PostInsertRequestDTO postInsertRequestDTO, Long memberId);
    //- 게시글 수정 서비스
    public void modifyPost(PostUpdateRequestDTO postUpdateRequestDTO, Long id);
    //- 게시글 삭제 서비스
    public void remove(Long id);
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteById(Long memberId);
}
