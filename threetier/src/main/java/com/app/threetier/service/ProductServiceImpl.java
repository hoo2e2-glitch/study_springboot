package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public void insertProduct(ProductVO productVO) {
        productDAO.saveProduct(productVO);

    }
}
