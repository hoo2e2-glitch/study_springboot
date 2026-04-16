package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostInsertRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.excetion.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor =  Exception.class)
//8. Service Implements(트랜잭션, 예외처리, 서비스이름이 들어나도록)
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    //- 게시글 목록 조회 서비스
    @Override
    public List<PostDTO> getPostList(String order) {
        Map<String, String> orders = new HashMap<>();
        orders.put("order", order);
        return postDAO.getPosts(orders);
    }

    //- 게시글 상세보기 조회 서비스
    public PostDTO getPostDetail(Long id) {
    // DAO - Optional 반환 -> service 바로 return x -> orElseThrow() 처리
//        Optional<PostDTO> foundPost = postDAO.findPostById(id);
//
//        if (foundPost.isPresent()) {
//            return foundPost.get();
//        }
//        throw new PostException();
        // handling 배움 4/16일
        return postDAO.getPost(id).orElseThrow(() -> { throw new PostException("게시글을 찾을 수 없습니다", HttpStatus.NOT_FOUND);});
//        return postDAO.findPostById(id).orElseThrow(PostException::new);
    }
    //- 게시글 작성 서비스
    public void writePost(PostInsertRequestDTO postInsertRequestDTO, Long memberId) {
        PostVO postVO = PostVO.from(postInsertRequestDTO);
        postVO.setMemberId(memberId);
        postDAO.savePost(postVO);
    }
    //- 게시글 수정 서비스
    public void modifyPost(PostUpdateRequestDTO postUpdateRequestDTO, Long id) {
        // postVO.setId(id);
        PostVO postVO = PostVO.from(postUpdateRequestDTO);
        postVO.setId(id);
        postDAO.updatePost(postVO);
    }
    //- 게시글 삭제 서비스
    public void remove(Long id) {
        postDAO.deletePost(id);
    }
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteById(Long memberId) {
        postDAO.deleteByMemberId(memberId);
    }
}
