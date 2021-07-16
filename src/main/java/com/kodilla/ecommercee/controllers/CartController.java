package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final UserMapper userMapper;
    private final CartMapper cartMapper;
    private final CartDbService service;
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ProductMapper productMapper;

    @GetMapping(value = "/emptyShoppingCart/{userId}")
    public void emptyShoppingCart(@PathVariable Long userId) throws UserNotFoundException {
        service.emptyShoppingCart(userId);
    }

    @GetMapping(value = "/getProductsFromShoppingCart/{cartId}")
    public List<ProductDto> getProductsFromShoppingCart(@PathVariable Long cartId) throws CartNotFoundException {
        List<Product> products = service.getProductsFromShoppingCart(cartId);
        return productMapper.mapToProductDtoList(products);
    }

    @PostMapping(value = "/addProduct/add/{cartId}/{productId}")
    public void addProduct(@PathVariable Long cartId, @PathVariable Long productId)
            throws ProductNotFoundException, CartNotFoundException {
        service.addProductToCart(cartId, productId);
    }

    @GetMapping(value = "/removeProduct/product/{productId}/{cartID}")
    void removeProduct(@PathVariable Long productId, @PathVariable Long cartID) throws CartNotFoundException {
        service.deleteProductFromCart(productId, cartID);
    }

    @GetMapping(value = "/createOrder/{cartId}")
    public OrderDto createOrder(@PathVariable Long cartId) {
        return orderMapper.mapToOrderDto(service.CreateOrder(cartId));
    }

    @GetMapping(value = "/getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(service.getCarts());
    }
}
