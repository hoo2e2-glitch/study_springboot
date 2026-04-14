package com.app.threetier.controller;


import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.service.CompanyService;
import io.micrometer.observation.Observation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/companies/*")
public class CompanyController {

    private final CompanyService companyService;

    // 출퇴근 등록
    @GetMapping("check-in")
    public void getToCheckInForm(@ModelAttribute CompanyVO companyVO) {;}

    @PostMapping("check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag) {
        LocalDateTime now = LocalDateTime.now();

        // 년 월 일 시 분 초
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int hour = now.getHour();
        int minute = now.getMinute();

        // 지각
        boolean isLateCondition = hour >= 9 && minute >= 0;

        // 퇴근
        boolean isLeaveCondition = hour >= 18 && minute >= 0;

        //  출근처리
        if(flag.equals("getToWork")) {
            companyVO.setLeaveToWorkDatetime(format);
            companyService.registerCommuteStatus(companyVO);

            // 정상 룰근 시간 초과 ? 지각 : 정상 출근
            return new RedirectView(isLateCondition ? "/companies/late" : "/companies/get-To-Work");

        }else if(flag.equals("leaveToWork")) {
            companyVO.setLeaveToWorkDatetime(format);
            companyService.registerCommuteStatus(companyVO);

            // 정상 퇴근 시간 ? 퇴근 : 무단 결근
            return new RedirectView(isLeaveCondition ? "/companies/leave-To-Work" : "/companies/work");

        }
        return new RedirectView("/companies/check-in");
    };

    @GetMapping("get-To-Work")
    public void getToWork() {;}

    @GetMapping("leave-To-Work")
    public void laveToWork(CompanyVO companyVO) {}

    @GetMapping("late")
    public void late(CompanyVO companyVO) {}

    @GetMapping("work")
    public void workCompany() {}
    }


























