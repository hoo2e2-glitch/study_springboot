package com.app.threetier.controller;


import com.app.threetier.domain.vo.TaskVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tasks/*")
public class TaskController {

    // 화면용
    @GetMapping("register")
    public String register(){
        return "/tasks/register";
    }

    // 결과 보여줌
    @GetMapping("result")
    public String result(Model model, TaskVO taskVO){
        int total = taskVO.getEng() + taskVO.getMath() + taskVO.getKor();
        int ave = total / 3 ;

        model.addAttribute("taskVO", taskVO);
        model.addAttribute("total", total);
        model.addAttribute("ave", ave);
        return "/tasks/result";



    }





}















