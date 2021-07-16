package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartTestSuite {

   @Autowired
   private CartDao cartDao;

   @Autowired
   private UserDao userDao;

   @Test
   public void testCartEntity() {

       //Given
       Product product1 = new Product("product1", "description1", new BigDecimal(1));
       Product product2 = new Product("product2", "description2", new BigDecimal(1));
       Product product3 = new Product("product3", "description3", new BigDecimal(1));

       User user = new User("User1");

       Cart cart = new Cart();

       cart.getShoppingCart().add(product1);
       cart.getShoppingCart().add(product2);
       cart.getShoppingCart().add(product3);

       cart.setUser(user);

       user.setCart(cart);

       cartDao.save(cart);

       //When
       Long cartId = cart.getId();
       Optional<Cart> foundCart = cartDao.findById(cartId);
       Long userId = user.getId();
       Optional<User> foundUser = userDao.findById(userId);

       //Then
       assertTrue(foundCart.isPresent());
       assertEquals(3, foundCart.get().getShoppingCart().size());
       assertEquals(foundUser.get().getCart().getId(), cartId);

       //Cleanup
       cartDao.deleteAll();
   }
}
