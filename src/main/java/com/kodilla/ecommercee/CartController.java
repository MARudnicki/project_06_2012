package com.kodilla.ecommercee;

import com.kodilla.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping("emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
        userDto.setCard(new CardDto());
        userDto.getCard().setShoppingCart(new ArrayList<>());
    }

    @GetMapping("getProductsShoppingCart/{productId}")
    public List<ProductDto> getProductsShoppingCart(@RequestParam CartDto cartDto) {
        return cartDto.getShoppingCart();
    }

    @PutMapping(value = "addProduct", consumes = APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody ProductDto product, CartDto cartDto) {
        cartDto.getShoppingCart().add(product);
    }

    @DeleteMapping("removeProduct")
    void removeProduct(@RequestParam int productId, CartDto cartDto) {
        cartDto.getShoppingCart().remove(productId);
    }

    @PostMapping("createOrder")
    public OrderDto createOrder(@RequestParam UserDto user, CartDto cartDto) {
        return new OrderDto(user.getId(), false, cartDto.getShoppingCart());
    }
}
