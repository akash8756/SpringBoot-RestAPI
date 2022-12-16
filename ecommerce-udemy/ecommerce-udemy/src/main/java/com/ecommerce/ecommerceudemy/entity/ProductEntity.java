package com.ecommerce.ecommerceudemy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_entity")
public class ProductEntity {

    @Id
    @SequenceGenerator(name = "seq_product_entity", sequenceName = "seq_product_entity", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seq_product_entity")
    @Column(name = "id")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private float unitPrice;

    @Column(name = "img_url")
    private String imageURL;

    @Column(name = "active")
    private boolean active;

    @Column(name = "unit_in_stock")
    private Long unitInStock;

   /* @Column(name = "date_created")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;2

    @Column(name = "last_updated")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    private ProductCategoryEntity productCategory;

}
