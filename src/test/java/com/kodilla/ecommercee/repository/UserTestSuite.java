package com.kodilla.ecommercee.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserEntity() {
        //Given


        //When


        //Then


        //CleanUp
        userDao.deleteAll();

    }

}
