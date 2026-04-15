package com.app.restful.repository;

import com.app.restful.domain.dto.PostListResponseDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Optional 처리 -> 공식
@Repository
@RequiredArgsConstructor
//6. DAO(단일객체는 Optional, 이름 준수)
public class PostDAO {

    private final PostMapper postMapper;

    //- 게시글 목록 조회 서비스
    public List<PostListResponseDTO> findPostList(){
        return postMapper.selectAll();
    }
    //- 게시글 상세보기 조회 서비스
    public Optional<PostListResponseDTO> findPostById(Long id){
        return Optional.ofNullable(postMapper.selectById(id));
    }
    //- 게시글 작성 서비스
    public void savePost(PostVO postVO){
        postMapper.insert(postVO);
    }
    //- 게시글 수정 서비스
    public void updatePost(PostVO postVO){
        postMapper.update(postVO);
    }
    //- 게시글 삭제 서비스
    public void deletePost(Long id){
        postMapper.delete(id);
    }
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteByMemberId(Long memberId){
        postMapper.deleteByMemberId(memberId);
    }




}
