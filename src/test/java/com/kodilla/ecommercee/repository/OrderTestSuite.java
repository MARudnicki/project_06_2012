package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
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

    @Test
    public void testOrderEntity() {
        /* Given */
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(null,"product 01", "description 01", new BigDecimal(100), null, null));
        products.add(new Product(null, "product 02", "description 02", new BigDecimal(200), null, null));
        products.add(new Product(null,"product 03", "description 03", new BigDecimal(300), null, null));

        User user = new User();
        userDao.save(user);

        Order order  = new Order(null, user, products);
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
        orderDao.deleteAll();
    }
}