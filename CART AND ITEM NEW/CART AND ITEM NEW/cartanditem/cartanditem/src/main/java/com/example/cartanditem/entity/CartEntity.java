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
    @SequenceGenerator(name = "seq_cart_id", initialValue = 100, sequenceName = "seq_cart_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart_id")
    @Column(name = "cart_Id")
    private Long cartId;
    @Column(name = "cart_name")
    private String cartName;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> items;
}
