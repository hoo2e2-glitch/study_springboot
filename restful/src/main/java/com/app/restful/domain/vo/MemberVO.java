package com.app.restful.domain.vo;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Data
// 다른서버와 소통 이뤄지는 vo
public class MemberVO {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }
}
