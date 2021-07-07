package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    public void isUserSavedTest() {
        //Given
        User user1 = new User();

        //When
        userDao.save(user1);

        //Then
        assertTrue(userDao.findById(user1.getId()).isPresent());

        //CleanUp
        userDao.deleteAll();

    }

    @Test
    public void isUserDeletedTest() {
        //Given
        User user1 = new User();
        userDao.save(user1);

        //When
        userDao.delete(user1);

        //Then
        assertFalse(userDao.findById(user1.getId()).isPresent());

        //CleanUp
        userDao.deleteAll();

    }

    @Test
    public void userEntityTest() {
        //Given
        List<Order> orders = new ArrayList<>();
        Cart cart1 = new Cart();
        User user1 = new User(1L, "UserA", true, BigDecimal.valueOf(12345), orders, cart1);

        //When
        userDao.save(user1);

        //Then
        assertEquals(1L, user1.getId());
        assertEquals("UserA", user1.getUsername());
        assertEquals(true, user1.getStatus());
        assertEquals(BigDecimal.valueOf(12345), user1.getUserKey());

        //CleanUp
        userDao.deleteAll();

    }

}
