package com.example.cascade_onetomanycartitems.mapper;

import com.example.cascade_onetomanycartitems.entity.CartEntity;
import com.example.cascade_onetomanycartitems.entity.ItemEntity;
import com.example.cascade_onetomanycartitems.model.CartRequest;
import com.example.cascade_onetomanycartitems.model.ItemRequest;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CartMapper {
    public CartEntity modelToEntity(CartRequest cartRequest);

    public CartRequest entityToModel(CartEntity cartEntity);

    public List<CartRequest> entityToModels(List<CartEntity> cartEntities);



}
