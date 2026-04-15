package com.app.restful.service;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostListResponseDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//7. Service 인터페이스(확장성)
public interface PostService {

    //- 게시글 목록 조회 서비스
    public List<PostListResponseDTO> findAll();
    //- 게시글 상세보기 조회 서비스
    public PostListResponseDTO findById(Long id);
    //- 게시글 작성 서비스
    public void writePost(PostInsertRequestDTO postInsertRequestDTO);
    //- 게시글 수정 서비스
    public void update(PostUpdateRequestDTO postUpdateRequestDTO);
    //- 게시글 삭제 서비스
    public void delete(Long id);
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteById(Long memberId);
}
