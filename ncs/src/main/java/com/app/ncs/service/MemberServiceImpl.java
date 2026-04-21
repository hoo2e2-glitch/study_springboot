package com.app.ncs.service;

import com.app.ncs.domain.dto.MemberJoinRequestDTO;
import com.app.ncs.domain.dto.MemberResponseDTO;
import com.app.ncs.domain.dto.MemberUpdateRequestDTO;
import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.exception.MemberException;
import com.app.ncs.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    // 회원가입
    @Override
    public void join(MemberJoinRequestDTO memberJoinRequestDTO) {
        // 이메일 중복 여부 확인
        this.checkMemberEmailDuplicate(memberJoinRequestDTO.getMemberEmail());
        // 회원 정보 추가 할 수 있도록 코드 리팩토링
        // 서비스 단에서 DTO -> VO 옮겨담는다
        memberDAO.save(MemberVO.from(memberJoinRequestDTO));
    }

    @Override
    // 로그인 서비스
    // 화면에 비밀번호 X -> ResponseDTO
    // 아이디 또는 비밀번호가 일치않으면 throw!
    // 아이디와 비밀번호가 일치하는 회원정보를 화면으로 응답
    public MemberResponseDTO login(MemberVO memberVO) {
        return memberDAO.findByMemberEmailAndPassword(memberVO)
                .map(MemberResponseDTO::from)
                .orElseThrow(() -> {
                    throw new MemberException("아이디 또는 비밀번호를 확인", HttpStatus.UNAUTHORIZED);
                });
    }

    // 전체 조회
    @Override
    public List<MemberResponseDTO> getMemberList() {
        return memberDAO.findAll().stream().map(MemberResponseDTO::from).toList();
    }

    // 단일 조회
    @Override
    public MemberResponseDTO getMemberId(Long id) {
        return memberDAO.findById(id)
                        .map(MemberResponseDTO::from)
                        .orElseThrow(() -> {
                             throw new MemberException("회원을 찾을 수 없", HttpStatus.BAD_REQUEST);
        });
    }

    // 이메일 중복 확인
    @Override
    public void checkMemberEmailDuplicate(String memberEmail) {
        if(memberDAO.existMemberEmail(memberEmail) > 0){
//        if(memberDAO.existMemberEmail(memberEmail).isPresent()){ // boolean 반환해서 사용
            throw new MemberException("이메일 존재", HttpStatus.CONFLICT);
        }
    }

    // update
    @Override
    public void updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        memberDAO.update(MemberVO.from(memberUpdateRequestDTO));
    }

    // delete
    @Override
    public void withdrawMember(Long id) {
        memberDAO.delete(id);
    }
}
