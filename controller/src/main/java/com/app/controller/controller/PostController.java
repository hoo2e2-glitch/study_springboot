package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.domain.vo.PostVO;
import com.app.controller.mapper.MemberMapper;
import com.app.controller.mapper.PostMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


// controller 알려주기 / 엔드포인트
@Controller
//요청경로 mapping  / frontcontroller역할
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostMapper postMapper;
    private final MemberMapper memberMapper;

    @GetMapping("list")
    public String goToPosts(@ModelAttribute PostVO postVO, Model model) {
        if(postVO.getId() != null) {
            Optional<PostVO> post = postMapper.select(postVO.getId());
            if(post.isPresent()) {
                model.addAttribute("post", post.get());
                return  "posts/detail";
            }
        }

        model.addAttribute("posts", postMapper.selectAll());
        return "posts/list";
    }

//    @GetMapping("detail")
//    public Optional<PostVO> posts(Long id) {
//        Optional<PostVO> selectpost = postMapper.select(id);
//        return selectpost;
//    }


//  리스트 → 글쓰기 → 등록 → 다시 리스트 흐름
    @GetMapping("write")
    public void goToPostsWrite() {;}



    }















