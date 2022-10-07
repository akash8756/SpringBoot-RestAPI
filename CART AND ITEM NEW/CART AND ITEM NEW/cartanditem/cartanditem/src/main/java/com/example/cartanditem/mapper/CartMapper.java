package com.example.cartanditem.mapper;


import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    public CartEntity modelToEntity(Cart cartRequest);

    public Cart entityToModel(CartEntity cartEntity);

    public List<Cart> entityToModels(List<CartEntity> cartEntities);

}
