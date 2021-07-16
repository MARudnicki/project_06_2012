package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.OrderDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
    private final OrderDao orderDao;

    //wyjatki drobic
    public void emptyShoppingCart(Long userId) {
        cartDao.save(new Cart(userDao.findById(userId).get().getId(),
                userDao.findById(userId).get().getCart().getShoppingCart(),
                userDao.findById(userId).stream().collect(Collectors.toList()).get(0)));

    }

    /////////////// wyjatki drobic
    public void getProductsFromShoppingCart(Long cartId) throws CartNotFoundException {

        Optional<Cart> cartList = Optional.ofNullable(cartDao.findById(cartId)
                .orElseThrow(CartNotFoundException::new));
        List<Cart> collect = cartList.stream().collect(Collectors.toList());
    }

    ////////////// wyjatki poprawic
    @SneakyThrows
    public void addProductToCart(Long cartId, Long productId) {
        Optional<Product> product = Optional.ofNullable(productDao.findById(productId).orElseThrow(ProductNotFoundException::new));
        List<Product> productList = product.stream().collect(Collectors.toList());
        cartDao.findById(cartId).get().getShoppingCart().add(productList.get(0));
    }


    public void deleteProductFromCart(Long productId, Long cartID) throws CartNotFoundException {
        List<Product> operatedList = new ArrayList<>();

        Cart cart = cartDao.findById(cartID).orElseThrow(CartNotFoundException::new);
        List<Product> shoppingCart = cart.getShoppingCart();

        List<Product> collect = shoppingCart.stream()
                .filter(n -> !n.getId().equals(productId))
                .collect(Collectors.toList());

        operatedList.add((Product) collect);
        shoppingCart.removeAll(operatedList);
    }
//prawie zrobione
    public Order CreateOrder(Long cartId) {
        List<User> userList = userDao.findById(cartId).stream().collect(Collectors.toList());
        User user = userList.get(0);
        List<Product> orderedProducts = cartDao.findById(cartId).get().getShoppingCart();
        return orderDao.save(new Order(null,user,false,orderedProducts));
    }
}

