package com.app.ncs;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class NcsApplicationTests {

    @Autowired
    MemberMapper memberMapper;

    @Test
    public  void insert() {
        MemberVO memberVO = new MemberVO();

        memberVO.setId(1L);
        memberVO.setMemberEmail("11");
        memberVO.setMemberName("11");
        memberVO.setMemberPassword("11");
        memberMapper.insert(memberVO);
        log.info("{}", memberVO);

    }

    @Test
    public void selecttest(MemberVO memberVO) {

        log.info("{}", memberVO);



    }

}
