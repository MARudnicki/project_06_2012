package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
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

    @Test
    public void testOrderEntity() {
        /* Given */
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("product 01", "description 01", new BigDecimal(100), "1"));
        products.add(new Product("product 02", "description 02", new BigDecimal(200), "2"));
        products.add(new Product("product 03", "description 03", new BigDecimal(300), "3"));

        Order order  = new Order(1L, 10L, products);
        orderDao.save(order);

        /* When */
        Long id = order.getId();
        List<Product> productList = order.getProductList();
        Optional<Order> optionalOrder = orderDao.findById(id);
        /* Then */
        assertTrue(optionalOrder.isPresent());
        assertEquals(1L, order.getId());
        assertEquals(10L, order.getUserId());
        assertEquals(3, productList.size());
        /* Cleanup */
        orderDao.deleteById(id);
    }

}