package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.OrderDao;
import com.kodilla.ecommercee.repository.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void mapToProduct() throws OrderNotFoundException {

        //Given
        Group group = new Group("group1");
        groupDao.save(group);

        ProductDto productDto = new ProductDto("product1", "description", new BigDecimal("1"), group.getId());
        Product product = productMapper.mapToProduct(productDto);

        productDao.save(product);

        //When
        Long productId = product.getId();
        Optional<Product> optionalProduct= productDao.findById(productId);
        Long groupId = group.getId();
        Optional<Group> optionalGroup = groupDao.findById(groupId);

        //Then
        assertTrue(optionalProduct.isPresent());
        assertEquals(optionalGroup.get().getId(), optionalProduct.get().getGroup().getId());

        //Cleanup
        productDao.deleteAll();
        groupDao.deleteAll();
    }
}