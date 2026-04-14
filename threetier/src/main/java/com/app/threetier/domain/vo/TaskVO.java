package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {

    private Integer kor;
    private Integer eng;
    private Integer math;

}