package com.example.cartanditem.entity;

import com.example.cartanditem.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_item_id", name = "seq_item_id", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_item_id" )
    @Column(name = "item_Id")
    private Long id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private double price;
    @Column(name = "item_quantity")
    private Long qty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
