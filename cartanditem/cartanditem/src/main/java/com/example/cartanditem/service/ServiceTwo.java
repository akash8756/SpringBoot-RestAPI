/*
package com.example.cartanditem.service;

import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.mapper.CartMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import com.example.cartanditem.repository.CartRepository;
import com.example.cartanditem.repository.ItemRepository;
import com.example.cartanditem.response.CartResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ServiceTwo implements ItemRepository {
    private int qnty=0;
    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final CartMapper cartMapper;

    public ServiceTwo(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartMapper = cartMapper;
    }

//    public Items increaseQty(Long id, Items items){
//        ItemEntity itemEntity=new ItemEntity();
//        Optional<ItemEntity> optionalItemEntity=itemRepository.findByName();
//        List<ItemEntity> itemEntityList=new ArrayList<>();
//        if(optionalItemEntity.isPresent()){
//            qnty++;
//            itemEntity.setQty(qnty);
//
//            log.info("Qty added "+qnty);
//
//        }
//        itemRepository.save(itemEntity);
//        return items;
//    }
//
//    @Override
//    public Optional<ItemEntity> findByName() {
//        List<ItemEntity> itemEntityList=new ArrayList<>();
//        String name;
//
//        for (ItemEntity item:itemEntityList) {
//            //item.getId();
//            name=item.getName();
//           // item.getPrice();
//        }
//        return name ;
    }


   */
/* public CartResponse increaseQty(String  name,Cart cart){
        ItemEntity itemEntity=new ItemEntity();
        CartResponse cartResponse = new CartResponse();
        String name1;
        List<ItemEntity> itemEntityList=new ArrayList<>();
        List<Items> items= (List<Items>) cart.getItems().get(qnty);
        for (Items a:items) {
           name1= a.getName();
           if(name1.equals(name)){
               qnty++;
               itemEntity.setQty((long) qnty);
           }
           itemRepository.save(itemEntity);
        }

        return cartResponse;
    }*//*


    @Override
    public List<ItemEntity> findByName(String name) {
        List<ItemEntity> itemEntityList=itemRepository.findByName(name);
        List<ItemEntity> itemEntity=new ArrayList<>();
        if(itemEntityList !=null){
            itemEntityList.


        }
    }
}
*/
