package com.example.cascade_onetomanycartitems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private String cartName;

    private List<ItemRequest> items;
}
