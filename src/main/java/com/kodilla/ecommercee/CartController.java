package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping("emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
    }

    @GetMapping("getProductsShoppingCart")
    public List<ProductDto> getProductsShoppingCart(@RequestParam CartDto cartDto) {
        return cartDto.getShoppingCart();
    }

    @PutMapping("addProduct")
    public void addProduct(@RequestParam ProductDto product, CartDto cartDto) {
        cartDto.getShoppingCart().add(product);
    }

    @DeleteMapping("removeProduct")
    void removeProduct(@RequestParam int productId, CartDto cartDto) {
        cartDto.getShoppingCart().remove(productId);
    }

    @PostMapping("createOrder")
    public OrderDto createOrder(@RequestParam UserDto user, CartDto cartDto) {
        return new OrderDto(user.getId(),false,new ArrayList<>());
    }
}
