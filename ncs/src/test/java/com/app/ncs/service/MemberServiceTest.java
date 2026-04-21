package com.app.ncs.service;

import com.app.ncs.domain.dto.MemberJoinRequestDTO;
import com.app.ncs.domain.dto.MemberResponseDTO;
import com.app.ncs.domain.dto.MemberUpdateRequestDTO;
import com.app.ncs.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void joinTest(){
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();

        memberJoinRequestDTO.setMemberEmail("00000");
        memberJoinRequestDTO.setMemberPassword("00000");
        memberJoinRequestDTO.setMemberName("00000");

        memberService.join(memberJoinRequestDTO);
        log.info("회원가입완");
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberName("00000");
        memberVO.setMemberPassword("00000");
        memberVO.setMemberEmail("00000");

        memberService.login(memberVO);
        log.info("{}", memberService.login(memberVO));
    }

    @Test
    public void memberListTest(){
        memberService.getMemberList();
        log.info("{}", memberService.getMemberList());
    }

    @Test
    public void memberIdTest(){
        MemberVO memberVO = new MemberVO();

        memberVO.setId(81L);
        memberService.getMemberId(memberVO.getId());
        log.info("{}", memberService.getMemberId(memberVO.getId()));
    }

    @Test
    public void checkEmailTest(){
        memberService.checkMemberEmailDuplicate("");
    }

    @Test
    public void updateTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();

        memberUpdateRequestDTO.setId(81L);
        memberUpdateRequestDTO.setMemberPassword("0000011111");
        memberUpdateRequestDTO.setMemberName("0000011111");

        memberService.updateMember(memberUpdateRequestDTO);
        MemberResponseDTO member = memberService.getMemberId(81L);
        log.info("수정된 회원 정보 : {}", member);
    }

    @Test
    public void deleteTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(81L);
        memberService.withdrawMember(memberVO.getId());

        log.info("delete ok");

    }

}
