package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
// 다른서버와 소통 이뤄지는 vo
public class ProductVO {

    private Long id;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
    private String productBrand;
}