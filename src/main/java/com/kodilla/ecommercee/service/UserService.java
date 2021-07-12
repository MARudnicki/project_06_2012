package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userDao.findAll();
        }
        catch (EntityNotFoundException entityNotFoundException) {
            entityNotFoundException.fillInStackTrace();
        }
        return userList;
    }

    public User getUser(Long userId) throws UserNotFoundException {
        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(Long id){
        userDao.deleteById(id);
    }

}
