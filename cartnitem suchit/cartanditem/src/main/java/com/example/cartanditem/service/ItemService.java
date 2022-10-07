package com.example.cartanditem.service;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.mapper.ItemMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.model.Item;
import com.example.cartanditem.model.ItemResponse;
import com.example.cartanditem.repository.CartRepository;
import com.example.cartanditem.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ItemService {

 @Autowired
 private ItemMapper itemMapper;

 @Autowired
 private ItemRepository itemRepository;
 @Autowired
 private CartRepository cartRepository;


 public ItemResponse createItems(Item item) {
  ItemResponse itemResponse = new ItemResponse();
  ItemEntity itemEntity = itemMapper.modelToEntity(item);
  itemRepository.save(itemEntity);
  log.info("Item has been added successfully in your cart");
  itemResponse.setId(itemEntity.getId());
  return itemResponse;

 }

 public void updateCart(Item item, String name) {
  ItemEntity itemEntity = itemRepository.findByName(name);
  if (itemEntity.getName().equalsIgnoreCase(name)) {
   itemEntity.setQuantity(item.getQuantity());
   itemEntity.setPrice(item.getPrice());
   itemRepository.save(itemEntity);
  } else {
   throw new RuntimeException("No id found");
  }
 }
}
