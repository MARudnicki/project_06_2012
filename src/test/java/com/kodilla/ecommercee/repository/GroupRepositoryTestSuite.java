package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class GroupRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;

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

        groupRepository.save(group);

        //When
        Long id = group.getId();
        Optional<Group> foundGroup = groupRepository.findById(id);

        //Then
        assertTrue(foundGroup.isPresent());
        assertEquals(product1.getGroup(), group);

        //Cleanup
        groupRepository.deleteById(id);

    }

}