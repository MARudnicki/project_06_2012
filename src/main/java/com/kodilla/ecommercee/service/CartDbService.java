package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartDbService {

    private final ProductDao productDao;
    private final UserDao userDao;
    private final CartDao cartDao;

    public List<Cart> getCarts() {
        return cartDao.findAll();
    }

    public void emptyShoppingCart(Long userId) {
        Cart cart = new Cart();
        List<Product> productListM = new ArrayList<>();
        cart.setId(userId);
        cart.setShoppingCart(productListM);
        cartDao.save(cart);

    }

    public List<Product> getProductsFromShoppingCart(Long cartId) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartId).orElseThrow(CartNotFoundException::new);
        return cart.getShoppingCart();
    }

    public void addProductToCart(Long cartId, Long productId) throws ProductNotFoundException, CartNotFoundException {
        Optional<Cart> cart = Optional.ofNullable(cartDao.findById(cartId).orElseThrow(CartNotFoundException::new));
        Product product = productDao.findById(productId).orElseThrow(ProductNotFoundException::new);
        cart.get().getShoppingCart().add(product);

    }

    public void deleteProductFromCart(Long productId, Long cartID) throws CartNotFoundException {
        Cart cart = cartDao.findById(cartID).orElseThrow(CartNotFoundException::new);
        List<Product> products = cart.getShoppingCart().stream()
                .filter(product -> !product.getId().equals(productId))
                .collect(Collectors.toList());
        cart.getShoppingCart().removeAll(products);
    }

    public Order CreateOrder(Long cartId) {
        List<Product> orderedProducts = cartDao.findById(cartId).get().getShoppingCart();
        Order order = new Order();
        User user = userDao.findById(1L).stream().collect(Collectors.toList()).get(0);
        order.setProductList(orderedProducts);
        order.setUser(user);
        order.setRealised(false);
        return order;
    }
}
