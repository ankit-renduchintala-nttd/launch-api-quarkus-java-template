package com.launch.controllers;


import com.launch.mapper.UserMapper;
import com.launch.mapper.UserRequestMapper;
import com.launch.model.CreateUserRequest;
import com.launch.model.UpdateUserRequest;
import com.launch.model.User;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.service.delegate.UserApiService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
@Log4j2
public class UserApiImpl implements com.launch.controllers.UsersApi {

    private final UserApiService userApiService;
    private final UserMapper userMapper;
    private final UserRequestMapper userRequestMapper;


    @Override
    public User createUser(CreateUserRequest user) {
        UserEntity serviceUser = userApiService.createUser(userRequestMapper.mapCreateRequest(user));
        return userMapper.userFromDomainToResponse(serviceUser);
    }



    @Override
    public User deleteUser(String username) {
        return userMapper.userFromDomainToResponse(userApiService.deleteUser(username));
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> allUsers = userApiService.getAllUsers();
        return userMapper.usersFromDomainToResponse(allUsers);


    }

    @Override
    public User getUser(String username) {
        return userMapper.userFromDomainToResponse(userApiService.getUser(username));
    }



    @Override
    public User updateUser(String username, UpdateUserRequest updateUserRequest) {
        UserEntity serviceUser = userApiService.updateUser(username, userRequestMapper.mapUpdateRequest(updateUserRequest));
        return userMapper.userFromDomainToResponse(serviceUser);
    }
}