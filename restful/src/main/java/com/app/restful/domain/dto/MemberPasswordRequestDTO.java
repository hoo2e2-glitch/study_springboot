package com.app.restful.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class MemberPasswordRequestDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기

    private  String memberPassword;

    // 정적
//    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO) {
//        MemberVO memberVO = new MemberVO();
//
//        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
//        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
//        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
//        return memberVO;
//    }

}
