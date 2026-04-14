package com.app.threetier.repository;


import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

// repository (레포지토리)
// 엔티티에 의해 생성된 데이터 베이스 테이블에 직접 접근하는 메서드를 가진 객체 또는 인터페이스
@RequiredArgsConstructor
@Repository
public class ProductDAO {

    private final ProductMapper productMapper;

    public void saveProduct(ProductVO productVO) {
        productMapper.insert(productVO);
    }



}
