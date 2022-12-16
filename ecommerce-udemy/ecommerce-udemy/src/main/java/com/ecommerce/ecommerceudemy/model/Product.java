package com.ecommerce.ecommerceudemy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String sku;
    private String name;
    private String description;
    private float unitPrice;
    private String imageURL;
    private boolean active;
    private Long unitInStock;
    private ProductCategory productCategory;
    /*private Date dateCreated;
    private Date lastUpdated;*/

}
