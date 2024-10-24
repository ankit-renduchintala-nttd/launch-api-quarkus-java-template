package com.launch.mapper;

import com.launch.model.User;
import com.launch.template.domain.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    User userFromDomainToResponse(UserEntity entity);

    List<User> usersFromDomainToResponse(List<UserEntity> entities);
}
