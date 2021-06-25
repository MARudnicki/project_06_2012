package com.kodilla.ecommercee;

import com.kodilla.dto.CartDto;
import com.kodilla.dto.OrderDto;
import com.kodilla.dto.ProductDto;
import com.kodilla.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    CartDto cartDto;

    @PostMapping("emptyShoppingCart")
    public void emptyShoppingCart(UserDto userDto) {
        new CartDto(userDto, new ArrayList<>());
    }

    @GetMapping("getProductShoppingCart")
    public ProductDto getProductShoppingCart(@RequestParam long ProductId) {
        return new ProductDto(ProductId, "test", "test des", BigDecimal.valueOf(50), "test");
    }

    @PutMapping("addProduct")
    public void addProduct(@RequestParam ProductDto product) {
        cartDto.getShoppingCart().add(product);
    }

    @DeleteMapping("removeProduct")
    public void removeProduct(@RequestParam int productId) {
        cartDto.getShoppingCart().remove(productId);
    }

    @PostMapping("crateOrder")
    public OrderDto crateOrder(@RequestParam Long userid) {
        List<ProductDto> Products = cartDto.getShoppingCart();
        return new OrderDto(userid, false, Products);
    }
}
