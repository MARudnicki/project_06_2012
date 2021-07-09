package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping(value = "/emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
    }

    @GetMapping(value = "/getProductsShoppingCart/{cartId}")
    public List<ProductDto> getProductsShoppingCart(Long cartId) {
        return new ArrayList<>();
    }

    @PutMapping(value = "/addProduct")
    public void addProduct( @RequestBody ProductDto product) {

    }

    @DeleteMapping(value = "/removeProduct/{productId}")
    void removeProduct(@PathVariable int productId) {

    }

    @PostMapping(value = "/createOrder/{userId}")
    public OrderDto createOrder(@PathVariable Long userId) {
        return new OrderDto(userId, false, new ArrayList<>());
    }
}
