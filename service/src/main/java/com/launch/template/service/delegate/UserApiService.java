package com.launch.template.service.delegate;

import com.launch.template.domain.entity.UserEntity;
import com.launch.template.service.model.ServiceUser;

import java.util.List;

public interface UserApiService {
    UserEntity createUser(ServiceUser user);

    UserEntity deleteUser(String username);

    List<UserEntity> getAllUsers();

    UserEntity getUser(String username);

    UserEntity updateUser(String username, ServiceUser updateUserRequest);
}
