package com.ecommerce.ecommerceudemy.service;

import com.ecommerce.ecommerceudemy.entity.ProductCategoryEntity;
import com.ecommerce.ecommerceudemy.entity.ProductEntity;
import com.ecommerce.ecommerceudemy.mapper.ProductMapper;
import com.ecommerce.ecommerceudemy.model.Product;
import com.ecommerce.ecommerceudemy.model.ProductCategory;
import com.ecommerce.ecommerceudemy.repository.ProductEntityRepository;
import com.ecommerce.ecommerceudemy.repository.ProductRepository;
import com.ecommerce.ecommerceudemy.response.ProductResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    public ProductResponse addProduct(ProductCategory productCategory, Product product) {
        log.info("Service found");
        ProductCategoryEntity productCategoryEntity= productMapper.modelToEntity(productCategory);
        productRepository.save(productCategoryEntity);
        ProductEntity productEntity =productMapper.modelToEntity(product);
        productEntityRepository.save(productEntity);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productCategoryEntity.getId());
        return productResponse;
    }
}
