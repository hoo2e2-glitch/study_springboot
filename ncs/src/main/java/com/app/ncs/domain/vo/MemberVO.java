package com.app.ncs.domain.vo;


import com.app.ncs.domain.dto.MemberJoinRequestDTO;
import com.app.ncs.domain.dto.MemberUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class MemberVO implements Serializable {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    // requestDTO
    // RequestDTO -> VO
    // VO에는 보통 RequestDTO -> VO 변환 메서드 작성
    // 입력값을 DB에 저장하거나 수정하려고 내부 객체로 바꾸는 흐름
    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }

    public static MemberVO from(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        MemberVO memberVO = new MemberVO();

        memberVO.setId( memberUpdateRequestDTO.getId());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        return memberVO;
    }
}
