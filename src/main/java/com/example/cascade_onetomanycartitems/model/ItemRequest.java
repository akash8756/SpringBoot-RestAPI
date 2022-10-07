package com.example.cascade_onetomanycartitems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
    private String itemName;
    private double itemPrice;
    private Long itemQuantity;
}
