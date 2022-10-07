package com.example.cartanditem.mapper;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity modelToEntity(Items items);
    Items entityToModel(ItemEntity itemEntity);
    List<Items> entityToModel(List<ItemEntity> itemEntities);

}
