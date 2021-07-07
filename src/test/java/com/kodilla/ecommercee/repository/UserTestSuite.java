package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    public void userEntityTest() {
        //Given
        List<Order> orders = new ArrayList<>();
        Cart cart1 = new Cart();
        User user1 = new User(null, "UserA", true, BigInteger.valueOf(12345), orders, cart1);
        userDao.save(user1);

        //When
        Optional<User> optionalUser = userDao.findById(user1.getId());

        //Then
        assertEquals("UserA", optionalUser.get().getUsername());
        assertEquals(true, optionalUser.get().getStatus());
        assertEquals(BigInteger.valueOf(12345), optionalUser.get().getUserKey());

        //CleanUp
        userDao.deleteAll();

    }

}
