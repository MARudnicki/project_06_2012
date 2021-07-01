package com.kodilla.ecommercee;

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

    @PostMapping("emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
    }

    @GetMapping("/getProductsShoppingCart/{cartId}")
    public List<ProductDto> getProductsShoppingCart(Long cartId) {
        return new ArrayList<>();
    }

    @GetMapping("/addProduct/{product}&{cartDto}")
    public void addProduct(ProductDto product, CartDto cartDto) {
        cartDto.getShoppingCart().add(product);
    }

    @DeleteMapping("/removeProduct/{productId}&{cartDto}")
    void removeProduct(int productId, CartDto cartDto) {
        cartDto.getShoppingCart().remove(productId);
    }

    @PostMapping("/createOrder/{userId}")
    public OrderDto createOrder(@RequestBody Long userId) {
        return new OrderDto(userId, false, new ArrayList<>());
    }
}
