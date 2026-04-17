package com.app.ncs.controller;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpRequest;
import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    @GetMapping("join")
    public void goToJoin(MemberVO memberVO) {;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){

        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    @GetMapping("login")
    public void goToLogin(){;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {

        Optional<MemberVO> found = memberMapper.select(memberVO);
        if(found.isPresent()) {
            session.setAttribute("member", found.get());
            return new RedirectView("/members/my-page");
        }


        redirectAttributes.addFlashAttribute("isLogin", false);
        return new RedirectView("/members/login");

    }

    }
    @GetMapping("my-page")
    public void goToMyPage(){;}

    @GetMapping("update")
    public void goToUpdate(){;}

    @PostMapping("update")
    public RedirectView update(Model model){
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        memberVO.setId(memberVO.getId());
        memberMapper.update(memberVO);
        return new RedirectView("/members/my-page");

    }

    @PostMapping("logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/members/login");
    }

    @DeleteMapping("join")
    public RedirectView withdraw(){
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        memberVO.setId(memberVO.getId());
        memberMapper.update(memberVO);
        return new RedirectView("/members/join");
    }



}
