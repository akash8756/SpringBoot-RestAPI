package com.example.cascade_onetomanycartitems.service;

import com.example.cascade_onetomanycartitems.entity.CartEntity;

import com.example.cascade_onetomanycartitems.mapper.CartMapper;
import com.example.cascade_onetomanycartitems.model.CartRequest;
import com.example.cascade_onetomanycartitems.model.CartResponse;
import com.example.cascade_onetomanycartitems.repository.CartRepository;
import com.example.cascade_onetomanycartitems.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Log4j2
@Service
public class CartService {
    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;

        this.cartMapper = cartMapper;
    }

    public CartResponse createCart(CartRequest cartRequest) {

        CartEntity cartEntity = cartMapper.modelToEntity(cartRequest);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        log.info("cart has been created");

        return cartResponse;
    }

    public List<CartRequest> getAllCarts() {

        List<CartEntity> cartEntities = cartRepository.findAll();
        List<CartRequest> cartRequests = cartMapper.entityToModels(cartEntities);
        log.info("get all the carts");

        return cartRequests;
    }

    public CartRequest getById(Long cartId) {

        CartRequest cartRequest = new CartRequest();
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        cartRequest = cartMapper.entityToModel(cartEntity.get());
        log.info("get the cart ById");

        return cartRequest;

    }

    public CartRequest updateCart(Long cartId, CartRequest cartRequest) {

        CartEntity cartEntity = cartRepository.findById(cartId).get();
        CartEntity cartEntityOne = cartMapper.modelToEntity(cartRequest);

        cartEntityOne.setCartId(cartEntity.getCartId());
        log.info("cart has been updated");

        return cartRequest;
    }


    public void deleteById(Long cartId) {

        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);

        if (cartEntity.isPresent()) {

            cartRepository.deleteById(cartId);
            log.info("cart is successfully Deleted");

        } else {

            log.info("this cartId is not found in your database");
        }

    }


}
