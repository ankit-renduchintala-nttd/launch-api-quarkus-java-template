package com.launch.controllers;

import com.launch.mapper.UserMapper;
import com.launch.mapper.UserRequestMapper;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.service.delegate.UserApiService;
import com.launch.template.service.model.ServiceUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.launch.model.CreateUserRequest;
import com.launch.model.UpdateUserRequest;
import com.launch.model.User;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserApiImplTest {

    @Mock
    private UserApiService userApiService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRequestMapper userRequestMapper;

    @InjectMocks
    private UserApiImpl userApi;

    @Test
    void createUserSuccessfully() {
        CreateUserRequest request = buildTestCreateUserRequest("testUser","Test User","testuser@example.com");

        UserEntity userEntity = buildTestUserEntity("testuser","Test User","testuser@example.com");

        User expectedUser = new User();
        ServiceUser serviceUser = new ServiceUser();
        when(userRequestMapper.mapCreateRequest(request)).thenReturn(serviceUser);
        when(userMapper.userFromDomainToResponse(userEntity)).thenReturn(expectedUser);
        when(userApiService.createUser(serviceUser)).thenReturn(userEntity);

        User result = userApi.createUser(request);

        assertEquals(expectedUser, result);
        verify(userApiService, times(1)).createUser(any(ServiceUser.class));
        verify(userMapper, times(1)).userFromDomainToResponse(userEntity);
        verify(userRequestMapper, times(1)).mapCreateRequest(request);
    }

    @Test
    void deleteUserSuccessfully() {
        String username = "testUser";

        UserEntity userEntity = buildTestUserEntity("testuser","Test User","testuser@example.com");

        when(userApiService.deleteUser(any(String.class))).thenReturn(userEntity);
        User expectedUser = new User();
        when(userMapper.userFromDomainToResponse(userEntity)).thenReturn(expectedUser);

        User result = userApi.deleteUser(username);

        assertEquals(expectedUser, result);
        verify(userApiService, times(1)).deleteUser(any(String.class));
        verify(userMapper, times(1)).userFromDomainToResponse(userEntity);
    }

    @Test
    void getAllUsersSuccessfully() {
        UserEntity userEntity = buildTestUserEntity("testuser","Test User","testuser@example.com");

        List<UserEntity> allUsers = Collections.singletonList(userEntity);
        when(userApiService.getAllUsers()).thenReturn(allUsers);
        List<User> allResponseUsers = Collections.singletonList(new User());
        when(userMapper.usersFromDomainToResponse(allUsers)).thenReturn(allResponseUsers);

        List<User> result = userApi.getAllUsers();

        assertEquals(allResponseUsers,result);
        verify(userApiService, times(1)).getAllUsers();
        verify(userMapper, times(1)).usersFromDomainToResponse(allUsers);
    }

    @Test
    void getUserSuccessfully() {
        String username = "testUser";

        UserEntity userEntity = buildTestUserEntity("testuser","Test User","testuser@example.com");

        when(userApiService.getUser(any(String.class))).thenReturn(userEntity);
        User expectedUser = new User();
        when(userMapper.userFromDomainToResponse(userEntity)).thenReturn(expectedUser);

        User result = userApi.getUser(username);

        assertEquals(expectedUser, result);
        verify(userApiService, times(1)).getUser(any(String.class));
        verify(userMapper, times(1)).userFromDomainToResponse(userEntity);
    }

    @Test
    void updateUserSuccessfully() {
        String username = "updateduser";
        UpdateUserRequest request = new UpdateUserRequest();
        request.setName("Updated User");
        request.setEmail("updateduser@example.com");

        UserEntity userEntity = buildTestUserEntity("updateduser","Updated User","updateduser@example.com");


        ServiceUser serviceUser = new ServiceUser();
        when(userRequestMapper.mapUpdateRequest(request)).thenReturn(serviceUser);
        when(userApiService.updateUser(any(String.class), any(ServiceUser.class))).thenReturn(userEntity);
        User expectedUser = new User();
        when(userMapper.userFromDomainToResponse(userEntity)).thenReturn(expectedUser);

        User result = userApi.updateUser(username, request);

        assertEquals(expectedUser, result);
        verify(userApiService, times(1)).updateUser(any(String.class), any(ServiceUser.class));
        verify(userMapper, times(1)).userFromDomainToResponse(userEntity);
        verify(userRequestMapper, times(1)).mapUpdateRequest(request);
    }

    private UserEntity buildTestUserEntity(String username,String name,String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setName(name);
        userEntity.setEmail(email);
        return userEntity;
    }

    private CreateUserRequest buildTestCreateUserRequest(String username,String name,String email) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername(username);
        request.setName(name);
        request.setEmail(email);
        return request;
    }
}