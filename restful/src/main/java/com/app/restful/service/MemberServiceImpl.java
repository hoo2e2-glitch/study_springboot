package com.app.restful.service;

import com.app.restful.domain.dto.MemberDTO;
import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.excetion.MemberException;
import com.app.restful.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor =  Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;


    @Override
    public void join(MemberJoinRequestDTO memberJoinRequestDTO) {
        // 이메일 중복 여부 확인
        // 회원 정보 추가 할 수 있도록 코드 리팩토링 아래
        this.checkMemberEmailDuplicate(memberJoinRequestDTO.getMemberEmail());

        // 서비스 단에서 dto -> vo 로 옮겨담기
        memberDAO.save(MemberVO.from(memberJoinRequestDTO));
    }

    @Override
    public void checkMemberEmailDuplicate(String memberEmail) {
        if (memberDAO.existMemberEmail(memberEmail) > 0){
            throw new MemberException(memberEmail);
        }

    }

    // 로그인 서비스
    // 화면에 비밀번호 x
    // 아이디 또는 비밀버놓 일치 x ->  throw
    // 아이다와 비밀번호가 일치하는 회원정보를 화면으로 응답

    @Override
    // Optional 벗겨서 리턴
    public MemberDTO login(MemberVO memberVO) {
        return memberDAO.findByEmail(memberVO)
                .map(MemberDTO::from)
                .orElseThrow(() -> {
                    throw new MemberException("아이디 또는 비밀번호를 확인해주세요.");
                });
    }

    @Override
    public MemberDTO getMemberInfo(Long id) {
        // 회원 비밀번호 제거
//        MemberVO foundmember = memberDAO.findById(id);
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setId(foundmember.getId());

        return memberDAO.findById(id)
                .map(MemberDTO::from)
                .orElseThrow(() -> {
                    throw new MemberException("아이디 또는 비밀번호를 확인해주세요.");
                });
    }

    @Override
    public List<MemberDTO> getMemberList() {
        return memberDAO.findAll().stream().map(MemberDTO::from).toList();

    }

    @Override
    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        memberDAO.updateMember(MemberUpdateRequestDTO.from(memberUpdateRequestDTO));
    }

    // 회원 탈퇴
    public void deleteMemberInfo(Long id) {
        // 참조하고 있는 post 게시판 삭제
        // throw 던져야함
        memberDAO.deleteMember(id);
    }

}
