package com.app.threetier.service;

import com.app.threetier.domain.vo.CompanyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CompanyServiceTests {

    // 업캐스팅 - 인터페이스
    @Autowired
    private CompanyService  companyService;

    @Test
    public  void saveCompany() {
        CompanyVO companyVO = new CompanyVO();

        companyVO.setCompanyName("회사");
//        companyVO.setGetToWorkDatetime("2026-04-10 11:00:00");
        companyVO.setLeaveToWorkDatetime("2026-04-10 11:00:00");

        companyService.registerCommuteStatus(companyVO);


    }




}
