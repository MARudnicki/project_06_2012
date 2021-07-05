package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
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
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @ExtendWith(SpringExtension.class)
    @Test
    public void testEntityProduct() {

        //Given
        Product product = new Product(1L, "test", "test",
                new BigDecimal(500), "test",new Group(),new Order());
        //When
        productDao.save(product);
        Optional<Product> readProduct = productDao.findById(1L);

        //Then
        Assertions.assertTrue(readProduct.isPresent());

        //CleanUp
        productDao.deleteAll();
    }
}
