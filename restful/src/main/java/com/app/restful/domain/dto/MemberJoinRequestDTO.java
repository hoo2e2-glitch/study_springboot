package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class MemberJoinRequestDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기

    private String memberEmail;
    private  String memberPassword;
    private String memberName;


}
