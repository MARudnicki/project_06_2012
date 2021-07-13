package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repository.OrderDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMapperTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserDao userDao;

    @Test
    void mapToOrder() throws UserNotFoundException, ProductNotFoundException {

        //Given
        Product product1 = new Product("product1", "description1", new BigDecimal(1));
        Product product2 = new Product("product2", "description2", new BigDecimal(1));
        Product product3 = new Product("product3", "description3", new BigDecimal(1));

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        List<String> dtoProducts = new ArrayList<>();
        dtoProducts.add("product1");
        dtoProducts.add("product2");
        dtoProducts.add("product3");

        User user = new User();
        userDao.save(user);

        OrderDto orderDto = new OrderDto(user.getId(), true, dtoProducts);

        Order order = orderMapper.mapToOrder(orderDto);
        orderDao.save(order);

        //When
        Long orderId = order.getId();
        Optional<Order> optionalOrder = orderDao.findById(orderId);

        //Then
        assertEquals(3, optionalOrder.get().getProductList().size());

        /* Cleanup */
        userDao.deleteAll();
        productDao.deleteAll();
        orderDao.deleteAll();
    }
}