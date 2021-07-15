package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserKeyDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    @Autowired
    public UserMapper() {
    }

    public UserDto mapToUserDto(final User user, final Long validUserKeyTime){
        UserKeyDto userKeyDto = new UserKeyDto(user.getUserKey(), validUserKeyTime);
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getStatus(),
                new UserKeyDto(user.getUserKey(), userKeyDto.getValidUserKeyTime()),
                new CartDto()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map((User user) -> mapToUserDto(user, System.currentTimeMillis() + 60*60*1000))
                .collect(Collectors.toList());
    }

    public User mapToUser(UserDto userDto) throws UserNotFoundException {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey().getUserKey(),
                null
        );
    }

}
