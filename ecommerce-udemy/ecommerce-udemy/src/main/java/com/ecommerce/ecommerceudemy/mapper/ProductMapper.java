package com.ecommerce.ecommerceudemy.mapper;

import com.ecommerce.ecommerceudemy.entity.ProductCategoryEntity;
import com.ecommerce.ecommerceudemy.entity.ProductEntity;
import com.ecommerce.ecommerceudemy.model.Product;
import com.ecommerce.ecommerceudemy.model.ProductCategory;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductCategoryEntity modelToEntity(ProductCategory productCategory);
    ProductEntity modelToEntity(Product product);

}
