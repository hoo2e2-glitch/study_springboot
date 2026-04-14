package com.app.threetier.service;

import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.domain.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void insertTests(){

        StudentVO studentVO = new StudentVO();

        studentVO.setStudentName("김");
        studentVO.setKor(30);
        studentVO.setEng(30);
        studentVO.setMath(30);
        studentService.registerStudent(studentVO);

        log.info("student : {}", studentService.getStudent(studentVO.getId()));
    }

    @Test
    public void studentAllTests(){
        studentService.getStudentList().forEach(student -> log.info("student : {}", student));

    }

    @Test
    public void getStudentTest() {
        log.info("student : {}", studentService.getStudent(1L));
    }

    @Test
    public void updateStudentTest(){
        StudentVO studentVO = new StudentVO();
        // 수정전
        log.info("student : {}", studentService.getStudent(1L));

        studentVO.setStudentName("김");
        studentVO.setKor(30);
        studentVO.setEng(30);
        studentVO.setMath(30);
        studentService.updateStudent(studentVO);

        // 수정 후
        log.info("student : {}", studentService.getStudent(2L));

    }
    @Test
    public void delectStudentTest(){
        StudentVO studentVO = new StudentVO();
        studentService.deleteStudent(studentVO.getId());
    }





    }


