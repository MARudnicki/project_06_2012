package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderTestSuite {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testOrderEntity() {
        /* Given */
        Product product1 = new Product("product1", "description1", new BigDecimal(1));
        Product product2 = new Product("product2", "description2", new BigDecimal(1));
        Product product3 = new Product("product3", "description3", new BigDecimal(1));

        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        User user = new User();
        userDao.save(user);

        Order order  = new Order(null, user,true, products);
        orderDao.save(order);

        /* When */
        Long orderId = order.getId();
        Optional<Order> optionalOrder = orderDao.findById(orderId);
        Long userId = user.getId();

        /* Then */
        assertTrue(optionalOrder.isPresent());
        assertEquals(userId, optionalOrder.get().getUser().getId());
        assertEquals(3, optionalOrder.get().getProductList().size());

        /* Cleanup */
        userDao.deleteAll();
        productDao.deleteAll();
        orderDao.deleteAll();
    }
}
