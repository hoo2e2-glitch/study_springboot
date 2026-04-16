package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public  void saveMember() {
        log.info("memberService : {} ", memberService.getMemberInfo(3L));
    }

    @Test
    public void insertMember() {
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();

        memberJoinRequestDTO.setMemberEmail("1234");
        memberJoinRequestDTO.setMemberPassword("1234");
        memberJoinRequestDTO.setMemberName("1234");
        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void updateMemberInfo() {
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();

        memberUpdateRequestDTO.setId(22L);
        memberUpdateRequestDTO.setMemberPassword("5555");
        memberUpdateRequestDTO.setMemberName("5555");
        memberService.updateMember(memberUpdateRequestDTO);
    }

    @Test
    public void deleteMember() {
        MemberVO memberVO = new MemberVO();

        memberVO.setId(22L);
        memberService.withdraw(memberVO.getId());
    }
}




