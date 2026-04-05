package com.app.mybatis.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

// spring에게 알리기
@Component
// getter/setter
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}

