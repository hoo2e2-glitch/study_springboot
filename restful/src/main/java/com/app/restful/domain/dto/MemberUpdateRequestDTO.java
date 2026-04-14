package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class MemberUpdateRequestDTO {
//    required : 테이블에 not null 이거나 parameter값을 넘기면 넣기

    private Long id;
    private  String memberPassword;
    private String memberName;

    // 정적
    // 다형성
    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }

    public static MemberVO from(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        MemberVO memberVO = new MemberVO();

        memberVO.setId(memberUpdateRequestDTO.getId());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        return memberVO;
    }

}
