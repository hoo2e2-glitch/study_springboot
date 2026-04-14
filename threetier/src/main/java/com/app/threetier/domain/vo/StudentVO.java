package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {

    private Long id;
    private String studentName;
    private Integer kor;
    private Integer eng;
    private Integer math;
    // 위까지

    // 밑에는 +알파
    // 원래는 dto
//    private Integer total;
//    private Double aver;






}