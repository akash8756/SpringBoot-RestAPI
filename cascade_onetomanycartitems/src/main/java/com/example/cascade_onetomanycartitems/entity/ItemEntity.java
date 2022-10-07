package com.example.cascade_onetomanycartitems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_Id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_price")
    private double itemPrice;
    @Column(name = "item_quantity")
    private Long itemQuantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}

