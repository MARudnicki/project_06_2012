package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping(value = "/getUsers")
    public List<UserDto> getOrders() throws EntityNotFoundException {
        List<User> users = userService.getAllUsers();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping(value = "/getUser/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        Long validUserKeyTime = System.currentTimeMillis() + 60*60*1000;
        return userMapper.mapToUserDto(userService.getUser(userId), validUserKeyTime);
    }


    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        User user = userMapper.mapToUser(userDto);
        userService.saveUser(user);
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }

    @PutMapping(value = "/updateUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        User user = userMapper.mapToUser(userDto);
        Long validUserKeyTime = userDto.getUserKey().getValidUserKeyTime();
        User saveUser = userService.saveUser(user);
        return userMapper.mapToUserDto(saveUser, validUserKeyTime);
    }

    @PutMapping(value = "/blockUser")
    public UserDto blockUser(@RequestBody Long id) throws UserNotFoundException {
        User blockUser = userService.getUser(id);
        blockUser.setStatus(false);
        return userMapper.mapToUserDto(blockUser, System.currentTimeMillis() + 60*60*1000);
    }

    @PutMapping(value = "/updateUserKey")
    public UserDto updateUserKey(@RequestBody Long id) throws UserNotFoundException {
        int random5digsInt = 10000 + new Random().nextInt(90000);
        BigInteger userKey = new BigInteger(String.valueOf(random5digsInt));
        User updatedUser = userService.getUser(id);
        UserDto userDto = new UserDto(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getStatus(), new UserKeyDto(updatedUser.getUserKey(), System.currentTimeMillis() + 60*60*1000), null);
        Long validUserKeyTime = userDto.getUserKey().getValidUserKeyTime();
        if (userDto.getUserKey().getValidUserKeyTime() < System.currentTimeMillis() - 60*60*1000)
            validUserKeyTime = System.currentTimeMillis() + 60*60*1000;
        UserDto updatedUserDto = new UserDto(userDto.getId(), userDto.getUsername(), userDto.getStatus(), new UserKeyDto(userKey, validUserKeyTime), new CartDto());
        User saveUpdatedUser = userService.saveUser(updatedUser);
        return userMapper.mapToUserDto(saveUpdatedUser, updatedUserDto.getUserKey().getValidUserKeyTime());
    }

}
