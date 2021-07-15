package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartDao cartDao;

    public void emptyShoppingCart(Long userId) {

    }

    ///////////////
    public List<Product> getProductsFromShoppingCart(Long cartId) throws CartNotFoundException {
        Optional<Cart> cartList = Optional.ofNullable(cartDao.findById(cartId)
                .orElseThrow(CartNotFoundException::new));
        List<Cart> collect = cartList.stream().collect(Collectors.toList());
        Cart cart = collect.get(0);
        return cart.getShoppingCart();

    }

    //////////////
    public void addProductToCart(Cart cart) {

    }

    public void deleteProductFromCart(Long productId, Long cartID) throws CartNotFoundException {
        List<Product> operatedList = new ArrayList<>();
        Cart cart = cartDao.findById(cartID).orElseThrow(CartNotFoundException::new);
        List<Product> shoppingCart = cart.getShoppingCart();
        shoppingCart.stream().filter(n -> !n.getId().equals(productId));
        operatedList.add((Product) shoppingCart);
        shoppingCart.removeAll(operatedList);
    }

    public Order CreateOrder(User user) {

        return new Order(null,user.getCart().getUser(),
                false,user.getCart().getShoppingCart());
    }
}

