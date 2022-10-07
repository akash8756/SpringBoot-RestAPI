package com.example.cartanditem.controller;

import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.model.Item;
import com.example.cartanditem.model.ItemResponse;
import com.example.cartanditem.service.CartService;
import com.example.cartanditem.service.ItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemResponse> createItems(@RequestBody Item item) {
        ItemResponse itemResponse = itemService.createItems(item);
        return new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/carts/{name}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCart( @RequestBody Item item, @PathVariable String name)  {
        itemService.updateCart(item,name);
        return ResponseEntity.ok().build();
    }

}