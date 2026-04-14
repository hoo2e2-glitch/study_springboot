package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.exception.PostException;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 서비스에서
// 예외처리
// 트랜잭션관리
// 메인로직작성
@Service
@RequiredArgsConstructor
// 생략가능 (rollbackFor = {PostException.class ,Exception.class})
@Transactional(rollbackFor = {PostException.class ,Exception.class})
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostDTO> getPosts() {
        return postDAO.findAll();
    }

    @Override
    // db의 원자성
    // 일괄적관리
    public PostDTO getPost(Long id) {
        this.increaseReadCount(id);
        return postDAO.findById(id).orElseThrow(() -> new PostException("Post Not Found"));
    }

    @Override
    public void updatePost(PostVO postVO) {
        postDAO.update(postVO);
    }

    public void increaseReadCount(Long id) {
        postDAO.updateReadCount(id);
    }

    @Override
    public void deletePost(Long id) {
         postDAO.delete(id);

    }
}
