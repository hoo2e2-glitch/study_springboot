package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TaskServiceTests {


    @Test
    public void test(){
        TaskVO taskVO = new TaskVO();
        int total = taskVO.getEng() + taskVO.getMath() + taskVO.getKor();
        int avg = total / 3;

        log.info("{}", taskVO.getMath());



    }



}
