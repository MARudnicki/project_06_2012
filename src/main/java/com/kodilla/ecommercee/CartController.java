package com.kodilla.ecommercee;

import com.kodilla.dto.CartDto;
import com.kodilla.dto.OrderDto;
import com.kodilla.dto.ProductDto;
import com.kodilla.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping("emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
        new CartDto(userDto, new ArrayList<>());
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
        return new OrderDto(user.getId(), false, cartDto.getShoppingCart());
    }
}
