package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class GroupDaoTestSuite {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void testProductList() {

        //Given
        Product product1 = new Product("product1", "description1", new BigDecimal(1));
        Product product2 = new Product("product2", "description2", new BigDecimal(1));
        Product product3 = new Product("product3", "description3", new BigDecimal(1));

        Group group = new Group("group1");

        group.getProductList().add(product1);
        group.getProductList().add(product2);
        group.getProductList().add(product3);

        product1.setGroup(group);
        product2.setGroup(group);
        product3.setGroup(group);

        groupDao.save(group);

        //When
        Long groupId = group.getId();
        Optional<Group> foundGroup = groupDao.findById(groupId);
        Long product1Id = product1.getId();
        Optional<Product> foundProduct = productDao.findById(product1Id);

        //Then
        assertTrue(foundGroup.isPresent());
        assertEquals(3, foundGroup.get().getProductList().size());
        assertEquals(foundProduct.get().getGroup().getId(), groupId);

        //CleanUp
        groupDao.deleteAll();
    }

}