package com.example.cartanditem.controller;

import com.example.cartanditem.model.Cart;
import com.example.cartanditem.response.CartResponse;
import com.example.cartanditem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createItems(@RequestBody Cart cart) {
        CartResponse cartResponse = cartService.createItems(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getItems(@PathVariable Long id) {
        Cart cart = cartService.getItemsById(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping(path = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getAllItems() {
        List<Cart> cart = cartService.getAllItems();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> updateItems(@PathVariable Long id, @RequestBody Cart cart) {
        cart = cartService.updateItems(id, cart);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/carts/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        cartService.deleteItems(id);
        return ResponseEntity.ok().build();
    }

}
