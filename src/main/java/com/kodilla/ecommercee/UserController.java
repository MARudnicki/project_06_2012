package com.kodilla.ecommercee;

import com.kodilla.dto.CardDto;
import com.kodilla.dto.UserDto;
import com.kodilla.dto.UserKeyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/getUsers")
    public List<UserDto> getOrders() { return new ArrayList<>(); }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(2L, "Admin", true, new UserKeyDto(new BigDecimal(96997), System.currentTimeMillis()), new CardDto());
    }

    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto userDto) { }

    @PutMapping("updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(3L, "User", false, new UserKeyDto(new BigDecimal(31251), userDto.getUserKey().getValidUserKeyTime()), new CardDto());
    }

    @PutMapping("blockUser")
    public UserDto blockUser(@RequestBody UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUsername(), false, userDto.getUserKey(), new CardDto());
    }

    @PutMapping("updateUserKey")
    public UserDto updateUserKey(@RequestBody UserDto userDto) {
        int random5digsInt = 10000 + new Random().nextInt(90000);
        BigDecimal userKey = new BigDecimal(random5digsInt);
        Long validUserKeyTime = userDto.getUserKey().getValidUserKeyTime();
        if (userDto.getUserKey().getValidUserKeyTime() < System.currentTimeMillis() - 60*60*1000)
            validUserKeyTime = System.currentTimeMillis();
        return new UserDto(userDto.getId(), userDto.getUsername(), userDto.getStatus(), new UserKeyDto(userKey, validUserKeyTime), new CardDto());
    }

}
