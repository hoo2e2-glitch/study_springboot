package com.app.controller.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
// 다른서버와 소통 이뤄지는 vo
public class MemberVO implements Serializable {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
