package com.example.cartanditem.entity;

import com.example.cartanditem.model.Items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_cart_id", name = "seq_cart_id", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator ="seq_cart_id")
    @Column(name = "cart_Id")
    private Long cartId;
    @Column(name = "cart_name")
    private String cartName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> items;
}
