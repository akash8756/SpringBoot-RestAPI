package com.example.cartanditem.service;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.mapper.CartMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Items;
import com.example.cartanditem.repository.CartRepository;
import com.example.cartanditem.response.CartResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public CartResponse createItems(Cart cart) {
        CartEntity cartEntity = cartMapper.modelToEntity(cart);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cartEntity.getCartId());
        log.info("Item has been added successfully in your cart");
        return cartResponse;

    }

    public Cart getItemsById(Long id) {
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        Cart cart = new Cart();
        if (optionalCartEntity.isPresent()) {
            cart = cartMapper.entityToModel(optionalCartEntity.get());
            log.info("Received the item {} with " + id);
        } else {
            log.info("No items with id {} found " + id);
        }
        return cart;
    }

    public List<Cart> getAllItems() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        List<Cart> carts = cartMapper.entityToModels(cartEntities);
        log.info("Getting full list of all the items");
        return carts;
    }

    public Cart updateItems(Long id, Cart cart) {
        CartEntity cartEntity = new CartEntity();
        Optional<CartEntity> optionalCartEntity = Optional.of(cartRepository.findById(id).get());
        if (optionalCartEntity.isPresent()) {
            cartEntity = cartMapper.modelToEntity(cart);
            cartRepository.save(cartEntity);
            log.info("Items has been updated");

        } else {
            log.info("No items with id {} found " + id);
        }
        return cart;
    }

    public void deleteItems(Long id) {
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        if (optionalCartEntity.isPresent()) {
            cartRepository.deleteById(id);
            log.info("Item has been deleted");
        } else {
            log.info("No items with id {} found " + id);
        }
    }
}