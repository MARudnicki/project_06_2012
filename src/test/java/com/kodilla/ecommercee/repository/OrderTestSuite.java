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
        products.add(new Product(20L,"product 01", "description 01", new BigDecimal(100), null, null));
        products.add(new Product(30L, "product 02", "description 02", new BigDecimal(200), null, null));
        products.add(new Product(40L,"product 03", "description 03", new BigDecimal(300), null, null));

        Order order  = new Order(1L, 10L, products);
        orderDao.save(order);

        /* When */
        Long id = order.getId();
        List<Product> productList = order.getProductList();
        Optional<Order> optionalOrder = orderDao.findById(id);
        /* Then */
        assertEquals(1L, order.getId());
        assertEquals(10L, order.getUserId());
        assertEquals(3, productList.size());
        /* Cleanup */
        orderDao.deleteAll();
    }
}