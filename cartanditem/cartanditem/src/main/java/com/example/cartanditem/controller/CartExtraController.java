/*
package com.example.cartanditem.controller;

import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import com.example.cartanditem.response.CartResponse;
import com.example.cartanditem.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CartExtraController {

    @Autowired
    private final ServiceTwo serviceTwo;

    public CartExtraController(ServiceTwo serviceTwo) {
        this.serviceTwo = serviceTwo;
    }

    @PutMapping(path = "/items/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> increaseQty(@PathVariable String name , @RequestBody Cart cart){
        CartResponse cartResponse = new CartResponse(); serviceTwo.increaseQty(name,cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);

    }
}
*/
