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
import com.kodilla.ecommercee.service.OrderService;
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
    private final OrderService orderService;

    @GetMapping(value = "/emptyShoppingCart/{userId}")
    public void emptyShoppingCart(@PathVariable Long userId) {
        service.emptyShoppingCart(userId);
    }


    @GetMapping(value = "/getProductsFromShoppingCart/{cartId}")
    public void getProductsFromShoppingCart(@PathVariable Long cartId) throws CartNotFoundException {
        service.getProductsFromShoppingCart(cartId);
    }


    @GetMapping(value = "/addProduct/add{productId/to{cartId}")
    public void addProduct(@PathVariable Long cartId,@PathVariable Long productId) {
        service.addProductToCart(cartId,productId);
    }


    @GetMapping(value = "/removeProduct/product/{productId}/from/{cartID}")
    void removeProduct(@PathVariable Long productId, @PathVariable Long cartID) throws CartNotFoundException {
        service.deleteProductFromCart(productId, cartID);
    }

    @PostMapping(value = "/createOrder/{cartId}")
    public void createOrder(@PathVariable Long cartId){
      orderService.saveOrder(service.CreateOrder(cartId));
    }
}
