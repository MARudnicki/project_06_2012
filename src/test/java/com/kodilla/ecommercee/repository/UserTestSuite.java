package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        User user1 = new User("UserA");

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
        User user1 = new User("UserA");
        userDao.save(user1);

        //When
        userDao.delete(user1);

        //Then
        assertFalse(userDao.findById(user1.getId()).isPresent());

        //CleanUp
        userDao.deleteAll();

    }

}
