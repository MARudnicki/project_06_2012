package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class EcommerceeApplicationTests {

    @Autowired
    private ProductDao productDao;

    @Test
    public void contextLoads() {
    }


    @ExtendWith(SpringExtension.class)
    @Test
    public void testEntityProduct() {

        //Given
        Product product = new Product("test", "test", new BigDecimal(500));

        //When
        productDao.save(product);
        int id = Math.toIntExact(product.getId());
        Optional<Product> readProduct = productDao.findById(1L);

        //Then
        Assertions.assertTrue(readProduct.isPresent());

        //CleanUp
        productDao.deleteAll();
    }
}

