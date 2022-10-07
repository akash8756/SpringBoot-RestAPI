package com.example.cartanditem.service;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.mapper.CartMapper;
import com.example.cartanditem.mapper.ItemMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import com.example.cartanditem.repository.ItemRepository;
import com.example.cartanditem.response.CartResponse;
import com.example.cartanditem.response.ItemResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ItemService{

    @Autowired
    private final ItemMapper itemMapper;

    @Autowired
    private final CartMapper cartMapper;

    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemMapper itemMapper, CartMapper cartMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.cartMapper = cartMapper;
        this.itemRepository = itemRepository;
    }

    public ItemResponse createItems(Items items) {
        ItemEntity itemEntity = itemMapper.modelToEntity(items);
        itemRepository.save(itemEntity);
        log.info("Items has been added successfully.");
        ItemResponse itemResponse = new ItemResponse();
        itemEntity.setId(itemResponse.getId());
        return itemResponse;
    }

    public CartResponse updateItem(Items items, String name){
        ItemEntity itemEntity=itemRepository.findByName(name);
        if(itemEntity.getName().equalsIgnoreCase(name)){
            itemEntity.setQty(items.getQty());
            itemEntity.setPrice(items.getPrice());
            itemRepository.save(itemEntity);
            CartResponse cartResponse=new CartResponse();
            itemEntity.setId(cartResponse.getId());
            return cartResponse;
        }
        else {
            throw new RuntimeException("No items found");
        }
    }





 /*   public Items getByItemName(String name){
        CartEntity cartEntity=new CartEntity();
        Cart cart=new Cart();
        List<CartEntity> optionalItemEntities=itemRepository.findByName(name);
        if(optionalItemEntities.equals(cartEntity.getItems())){
            cart=cartMapper.

        }
    }*/

}


