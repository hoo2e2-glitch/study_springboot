package com.app.threetier.repository;


import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.CompanyMapper;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// repository (레포지토리)
// 엔티티에 의해 생성된 데이터 베이스 테이블에 직접 접근하는 메서드를 가진 객체 또는 인터페이스
@RequiredArgsConstructor
@Repository
public class CompanyDAO {
    private final CompanyMapper companyMapper;

    public void save (CompanyVO companyVO) {
        companyMapper.insert(companyVO);
    }




}
