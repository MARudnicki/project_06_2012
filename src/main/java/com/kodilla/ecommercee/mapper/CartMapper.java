package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    private final ProductDao productDao;

    @Autowired
    public CartMapper(final ProductDao productDao) {
        this.productDao = productDao;
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getShoppingCart().stream()
                        .map(
                                p -> {
                                    try {
                                        return productDao.findByName(p).orElseThrow(ProductNotFoundException::new);
                                    } catch (ProductNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }).collect(Collectors.toList()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getShoppingCart().stream().map(Product::getName).collect(Collectors.toList())
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList
                .stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
