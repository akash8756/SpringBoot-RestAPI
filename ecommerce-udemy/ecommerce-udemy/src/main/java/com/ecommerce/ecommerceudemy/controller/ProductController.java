package com.ecommerce.ecommerceudemy.controller;

import com.ecommerce.ecommerceudemy.model.Product;
import com.ecommerce.ecommerceudemy.model.ProductCategory;
import com.ecommerce.ecommerceudemy.response.ProductResponse;
import com.ecommerce.ecommerceudemy.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/products")
    private ResponseEntity<ProductResponse> addProduct(@RequestBody ProductCategory productCategory, Product product){
        log.info("controller found");
        ProductResponse productResponse=productService.addProduct(productCategory, product);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
