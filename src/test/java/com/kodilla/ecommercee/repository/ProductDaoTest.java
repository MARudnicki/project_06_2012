package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;


@SpringBootTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;


    @Test
    public void testEntityProduct() {

        //Given
        Product product = new Product(1L, "test", "test",
                new BigDecimal(500), new Group(), new Order());
        //When
        productDao.save(product);
        Optional<Product> readProduct = productDao.findById(1L);

        //Then
        Assertions.assertTrue(readProduct.isPresent());

        //CleanUp
        productDao.deleteAll();

    }
}
