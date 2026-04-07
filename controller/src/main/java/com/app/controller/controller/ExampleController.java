package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
// controller 알려주기
@Controller
//요청경로 mapping  / frontcontroller역할
@RequestMapping("/ex/*")
public class ExampleController {

    @GetMapping("/ex01")
    public String ex01(String name, int age){
        log.info("ex01 응답완료");

        log.info("name : {}, age : {}", name, age);
        log.info("name : {}, age : {}, realAge: {}", name, age, age - 1);

        // get 방식으로 데이터를 어떻게 보내는?
        // 이름 나이를 요청보내고
        // 이름 나이 만나이를 로그에 출력하기


      // ex01.html
      // ex01 -> templates/ex01.html
      //
      // 응답되는 페이지의 파일 경로
      //   페이지 경로
        return "ex01";
    }
    @PostMapping("/ex01")
    public void ex01Post(String name, String age){
        log.info("name : {}, age : {}", name, age);
    }

    @GetMapping("ex02")
    public String ex02(String name, Model model){

        model.addAttribute("name",name);

        return  "ex02";

    }


    @GetMapping("ex03")
    public String ex03( Model model){

        //    홍길동/장보고/이순신 list에 담고
        //    화면에 보낸 후 반복문으로 출력
        List<String> nameList = Arrays.asList("홍길동","장보고","이순신");
//        ArrayList list = new ArrayList<>(Arrays.asList("홍길동","장보고","이순신"));
        model.addAttribute("nameList",nameList);
//        model.addAttribute("list",list);

        return "ex03";
    }

//  @ModelAttribute :  반드시 쿼리스티링 값을 전달해야한다.
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name") String name){

        return "ex04";
    }

//    model @ 활용!
//    이름 취미를 받고
//    화면에 이름: 000
//    취미: 000 출력
    @GetMapping("ex05")
    public  String ex05(@ModelAttribute("name") String name,
                        @ModelAttribute("hobby") String hobby){

        return "ex05";
    }

    @GetMapping("ex06")
    public String goToEx06(){
        return "ex06";
    }

    @GetMapping("ex06-complate")
    public String ex06Complate(@ModelAttribute("memberName")  String memberName){

        log.info("memberName : {}",memberName);
        return "ex06-complate";

    }

    @PostMapping("ex06")
     public String ex06(MemberVO memberVO){

        log.info("응답");
        log.info("memberVO : {} ", memberVO);

//        return "redirect:/ex/ex06-complate";
//        return "redirect:/ex/ex06-complate?memberName=" +  memberVO.getMemberName();
        return "redirect:/ex/ex06-complate";

     }

     //    회원가입 완료 후
     //    회원가입 완료 후 000님 환영합니다 출력




}
