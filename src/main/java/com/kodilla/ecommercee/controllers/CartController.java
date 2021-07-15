package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.CartDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final UserMapper userMapper;
    private final CartMapper cartMapper;
    private final CartDbService service;
    private final OrderMapper orderMapper;

    @GetMapping(value = "/emptyShoppingCart/{userId}")
    public void emptyShoppingCart(@PathVariable Long userId) {

    }

    //Ta juz jest raczej git
    @GetMapping(value = "/getProductsFromShoppingCart/{cartId}")
    public void getProductsFromShoppingCart(@PathVariable Long cartId) throws CartNotFoundException {
        service.getProductsFromShoppingCart(cartId);
    }

    //Ta juz jest raczej git
    @PutMapping(value = "/addProduct")
    public void addProduct(@RequestBody CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        service.addProductToCart(cart);
    }

    @DeleteMapping(value = "/removeProduct/product/{productId}/from/{cartID}")
    void removeProduct(@PathVariable Long productId, @PathVariable Long cartID) throws CartNotFoundException {
        service.deleteProductFromCart(productId, cartID);
    }

    @PostMapping(value = "/createOrder")
    public OrderDto createOrder(@RequestBody UserDto userDto) throws UserNotFoundException {
        return orderMapper.mapToOrderDto(service.CreateOrder(userMapper.mapToUser(userDto)));
    }
}
