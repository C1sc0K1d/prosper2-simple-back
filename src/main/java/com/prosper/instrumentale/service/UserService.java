package com.prosper.instrumentale.service;

import com.prosper.instrumentale.dto.UserDto;
import com.prosper.instrumentale.entities.User;
import com.prosper.instrumentale.mapper.UserMapper;
import com.prosper.instrumentale.repositories.UserRepository;
import com.prosper.instrumentale.request.UserRequest;
import com.prosper.instrumentale.response.UserListResponse;
import com.prosper.instrumentale.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse login(UserRequest userRequest) {
        return this.userMapper.toSingleResult(userRepository.findByUserNameAndPassword(userRequest.getUserName().toLowerCase(Locale.ROOT), userRequest.getPassword()));
    }

    public UserResponse addUser(UserRequest userRequest) throws Exception {
        var haveUser = userRepository.findByUserName(userRequest.getUserName().toLowerCase());

        System.out.println(haveUser);

        if (haveUser != null) {
            throw new Exception("User Aready Exist");
        };

        var user = userMapper.toUser(userRequest);
        user.setUserName(userRequest.getUserName().toLowerCase(Locale.ROOT));
        if (userRequest.getIsAdmin() == null) user.setIsAdmin(false);
        userRepository.save(user);
        return this.userMapper.toSingleResult(user);
    }

    public UserResponse updateUser(UserRequest userRequest) {
        var user = userRepository.findById(userRequest.getId()).get();

        if (userRequest.getIsAdmin() != null) user.setIsAdmin(userRequest.getIsAdmin());

        user.setAddress(userRequest.getAddress());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());

        user = userRepository.save(user);
        return userMapper.toSingleResult(user);
    }

    @Transactional(readOnly = true)
    public UserListResponse getAllUsers() {
        return this.userMapper.toListResult(this.userRepository.findAll());
    }

    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }

}
