package com.app.threetier.controller;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


// controller 알려주기 / 엔드포인트
@Controller
//요청경로 mapping  / frontcontroller역할
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 전체조회
    @GetMapping("list")
    public void goToPosts(Model model) {
        model.addAttribute("posts", postService.getPosts());
    }

    // 단일조회
    @GetMapping("read")
    public void goToPostsRead(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

//    게시글 수정 페이지 구현
    // 수정페이지 이동
    // 수정 페이지 열기  → 기존 제목, 내용 불러오기 → SELECT
    // select로 조회
    @GetMapping("update")
    public void goToPostsUpdate(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    // 실제수정
    @PostMapping("update")
    public String updatePost(PostDTO postDTO) {
        postService.updatePost(postDTO);
        return "redirect:/posts/list";
    }

    @PostMapping("delete")
    public String goToPostsDelete(Long id) {
        postService.deletePost(id);
        return "redirect:/posts/list";

    }


}















