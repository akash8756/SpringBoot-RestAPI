package com.example.cartanditem.entity;

import com.example.cartanditem.model.Cart;
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
    @SequenceGenerator(name = "seq_item_id", initialValue = 1000, sequenceName = "seq_item_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_id")
    @Column(name = "item_Id")
    private Long id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private double price;
    @Column(name = "item_quantity")
    private Long qty;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
