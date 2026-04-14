package com.app.threetier.controller;


import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("list")
    public void goToProduct(@ModelAttribute ProductVO productVO) {;}

    @PostMapping("list")
    public RedirectView product(ProductVO productVO){
        productService.insertProduct(productVO);
        return new RedirectView("/products/read");
    }




}















