package com.ecommerce.ecommerceudemy.repository;

import com.ecommerce.ecommerceudemy.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
