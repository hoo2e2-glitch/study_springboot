package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.mapper.MemberMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


// controller 알려주기 / 엔드포인트
@Controller
//요청경로 mapping  / frontcontroller역할
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberMapper memberMapper;
    //    의존성주입
    private final HttpSession session;

    //   회원가입
    @GetMapping("join")
    public void goToJoin(MemberVO memberVO) {;}

    //  요청-post-응답
//  값을 받아서 -> DB에 저장 -> 응답
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {

        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    //    로그인 실습
    //    로그인이 완료되면 members/my-page로 응답
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

    //    로그인 실습
//    로그인이 완료되면 /members/my-page로 응답
//    1. 쿼리 작성
//    select -> 이메일과, 비밀번호 검증 후 회원을 조회하는 쿼리
//    2. Mapper 작성
//    3. Mapper Interface 작업
//    4. 컨트롤러 생성

//    RedirectAttributes : 리다이렉트와 세션(session)을 통해 화면에 상태를 관리하면
//    session 과부화 되므로 session에 flash 영역에 주입이 되며 새로운 요청이 들어왔을 때
//    flash 영역을 사라지게된다. 즉 new Request() 객체를 만나면 사라진다
//    redirectAttributes.addFlashAttribute("key", value): 컨트롤러에서 사용이 가능
//     redirectAttributes.addAttribute("isLogin", true): 컨트롤러에서 사용이 불가능
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {

        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
        if (foundMember.isPresent()) {
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/members/my-page");
        }


        redirectAttributes.addFlashAttribute("isLogin", false);
        return new RedirectView("/members/login");

    }

//    5. Mapper(생성자 주입)
//    6. 회원을 정보를 받는다.
//    7. Mapper Select를 실행
//    8. 이메일 여부 또는 비밀번호의 여부를 확인해서 화면으로 리턴
//    9. Session에 회원 정보를 주입
//    10. 리다이렉트 처리

    @GetMapping("my-page")
    public void goToMyPage() {;}


    @GetMapping("update")
    public void goToUpdate(Model model) {
        model.addAttribute("member", session.getAttribute("member"));
    }


    @PostMapping("update")
    public RedirectView update(MemberVO memberVO) {
        memberMapper.update(memberVO);
        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
        if (foundMember.isPresent()) {
            session.setAttribute("member", foundMember.get());
    }
        return new RedirectView("/members/my-page");
    }


//    로그아웃
    public RedirectView logout() {
        // invalidate: 세션 값을 초기화
        session.invalidate();
//        session.removeAttribute("member");

        return new RedirectView("/members/login");
    }

//    회원탈퇴
    @DeleteMapping("withdraw")
    public RedirectView withdraw(){

        MemberVO member =  (MemberVO)session.getAttribute("member");
        memberMapper.delete(member.getId());

        return new RedirectView("/members/login");

    }

}









