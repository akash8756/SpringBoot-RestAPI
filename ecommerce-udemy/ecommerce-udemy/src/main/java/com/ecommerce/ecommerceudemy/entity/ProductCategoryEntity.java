package com.ecommerce.ecommerceudemy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category_entity")
public class ProductCategoryEntity {

    @Id
    @SequenceGenerator(name = "seq_product_category", sequenceName = "seq_product_category", initialValue = 9000, allocationSize = 1)
    @GeneratedValue(generator = "seq_product_category")
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    private List<ProductEntity> product;
}
