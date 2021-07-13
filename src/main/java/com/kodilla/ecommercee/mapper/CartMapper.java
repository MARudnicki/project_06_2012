package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper  {


    private final UserDao userDao;
    private final ProductDao productDao;

    @Autowired
    public CartMapper(final UserDao userDao, final ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getShoppingCart());
    }

    public CartDto mapToCartDto(final Cart cart){
        return  new CartDto(
                cart.getId(),
                cart.getShoppingCart()
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList
                .stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
