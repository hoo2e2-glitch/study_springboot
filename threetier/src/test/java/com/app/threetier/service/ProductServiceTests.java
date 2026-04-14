package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    public void insertProduct() {
        ProductVO productVO = new ProductVO();

        productVO.setProductName("productName1");
        productVO.setProductPrice(100001);
        productVO.setProductStock(55);
        productVO.setProductBrand("productBrand1");
        productService.insertProduct(productVO);



    }



}
