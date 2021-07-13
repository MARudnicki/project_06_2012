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

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;


    @Test
    public void testEntityProduct() {

        //Given
        Product product = new Product("product1", "description1", new BigDecimal(1));
        productDao.save(product);

        //When
        Optional<Product> readProduct = productDao.findById(product.getId());

        //Then
        assertTrue(readProduct.isPresent());

        //CleanUp
        productDao.delete(product);

    }
}
