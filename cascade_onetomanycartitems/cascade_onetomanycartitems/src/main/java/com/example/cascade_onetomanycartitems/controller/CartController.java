package com.example.cascade_onetomanycartitems.controller;

import com.example.cascade_onetomanycartitems.model.CartRequest;
import com.example.cascade_onetomanycartitems.model.CartResponse;
import com.example.cascade_onetomanycartitems.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/cart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = cartService.createCart(cartRequest);

        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/carts")
    public ResponseEntity<List<CartRequest>> getAllCarts() {
        List<CartRequest> cartRequest = cartService.getAllCarts();

        return new ResponseEntity<>(cartRequest, HttpStatus.OK);
    }

    @GetMapping(value = "/cart/{cartId}")
    public ResponseEntity<CartRequest> getById(@PathVariable Long cartId) {
        CartRequest cartRequest = cartService.getById(cartId);

        return new ResponseEntity<>(cartRequest, HttpStatus.OK);
    }

    @PutMapping(value = "/cart/{cartId}")
    public ResponseEntity<CartRequest> updateCart(@PathVariable Long cartId, @RequestBody CartRequest cartRequest) {
        CartRequest cartRequest1 = cartService.updateCart(cartId, cartRequest);

        return new ResponseEntity<>(cartRequest1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/cart/{cartId}")
    public void deleteById(@PathVariable Long cartId) {


        cartService.deleteById(cartId);
    }
}
