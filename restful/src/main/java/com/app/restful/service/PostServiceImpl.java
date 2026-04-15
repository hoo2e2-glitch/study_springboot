package com.app.restful.service;

import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostListResponseDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.excetion.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor =  Exception.class)
//8. Service Implements(트랜잭션, 예외처리, 서비스이름이 들어나도록)
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    //- 게시글 목록 조회 서비스
    @Override
    public List<PostListResponseDTO> findAll() {
        return postDAO.findPostList();
    }
    //- 게시글 상세보기 조회 서비스
    public PostListResponseDTO findById(Long id) {
    // DAO - Optional 반환 -> service 바로 return x -> orElseThrow() 처리
//        Optional<PostListResponseDTO> foundPost = postDAO.findPostById(id);
//
//        if (foundPost.isPresent()) {
//            return foundPost.get();
//        }
//        throw new PostException();
        return postDAO.findPostById(id).orElseThrow(PostException::new);
    }
    //- 게시글 작성 서비스
    public void writePost(PostInsertRequestDTO postInsertRequestDTO) {
        postDAO.savePost(PostVO.from(postInsertRequestDTO));
    }
    //- 게시글 수정 서비스
    public void update(PostUpdateRequestDTO postUpdateRequestDTO) {
        postDAO.updatePost(PostVO.from(postUpdateRequestDTO));
    }
    //- 게시글 삭제 서비스
    public void delete(Long id) {
        postDAO.deletePost(id);
    }
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteById(Long memberId) {
        postDAO.deleteByMemberId(memberId);
    }
}
