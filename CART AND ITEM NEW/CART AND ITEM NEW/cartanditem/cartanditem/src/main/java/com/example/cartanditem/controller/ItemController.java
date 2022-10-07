package com.example.cartanditem.controller;

import com.example.cartanditem.model.Items;
import com.example.cartanditem.response.CartResponse;
import com.example.cartanditem.response.ItemResponse;
import com.example.cartanditem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.attribute.standard.Media;

public class ItemController {
    @Autowired
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemResponse> createItems(@RequestBody Items items){
        ItemResponse itemResponse=itemService.createItems(items);
        return new ResponseEntity<>(itemResponse, HttpStatus.CREATED);
    }

    @PutMapping(path = "/items/{name}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> updateCart(@PathVariable String name, @RequestBody Items items){
        CartResponse cartResponse=itemService.updateItem(items,name);
        return new ResponseEntity<>(cartResponse,HttpStatus.OK);
    }
}
