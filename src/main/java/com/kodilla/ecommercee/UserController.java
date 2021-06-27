package com.kodilla.ecommercee;

import com.kodilla.dto.CardDto;
import com.kodilla.dto.OrderDto;
import com.kodilla.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/getUsers")
    public List<UserDto> getOrders() { return new ArrayList<>(); }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(2L, "Admin", true, new BigDecimal(96997), new CardDto());
    }

    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto userDto) { }

    @PutMapping("updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(3L, "User", false, new BigDecimal(31251), new CardDto());
    }

    @PutMapping("blockUser")
    public UserDto blockUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUsername(), false, userDto.getUserKey(), new CardDto());
    }

    @PutMapping("updateUserKey")
    public UserDto updateUserKey(@RequestBody UserDto userDto) {
        BigDecimal userKey = new BigDecimal(Math.random());;
        return new UserDto(userDto.getId(), userDto.getUsername(), userDto.getStatus(), userKey, new CardDto());
    }

}
