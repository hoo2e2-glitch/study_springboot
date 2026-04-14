package com.app.threetier.controller;


import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.repository.StudentDAO;
import com.app.threetier.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students/*")
public class StudentController {

    private final StudentService studentService;

    // 등록
    @GetMapping("register")
    public void goToStudent(@ModelAttribute StudentVO studentVO) {;}


    // 결과
    @PostMapping("result")
    public String student(StudentVO studentVO, Model model) {
        studentService.registerStudent(studentVO);
        model.addAttribute("student", studentService.getStudent(studentVO.getId()));
        return "students/result";
    }

    @GetMapping("result")
    public void gotoresult(Long id, Model model) {
        studentService.getStudent(id).ifPresent((student) -> {
                                                model.addAttribute("student", student);
                                                },
                                                () -> {
                                                    model.addAttribute("student", new StudentVO);
                                                }};

//    @PostMapping("result")
//    public String studentPoint(StudentVO studentVO) {
//        studentService.selectStudent(studentVO.getId());
//        return "students/result";
//    }

    }





















