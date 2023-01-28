package com.prosper.instrumentale.mapper;

import com.prosper.instrumentale.dto.UserDto;
import com.prosper.instrumentale.entities.User;
import com.prosper.instrumentale.request.UserRequest;
import com.prosper.instrumentale.response.UserListResponse;
import com.prosper.instrumentale.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User toUser(@Valid UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .userName(userRequest.getUserName())
                .isAdmin(userRequest.getIsAdmin())
                .password(userRequest.getPassword()).build();
    }

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .isAdmin(user.getIsAdmin())
                .password(user.getPassword()).build();
    }

    public List<UserDto> toUserListDto(List<User> users) {
        return users.stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public UserResponse toSingleResult(User user) {
        return UserResponse.builder().user(this.toUserDto(user)).build();
    }

    public UserListResponse toListResult(List<User> users) {
        return UserListResponse.builder().users(this.toUserListDto(users)).build();
    }
}
