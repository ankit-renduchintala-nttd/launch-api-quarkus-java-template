package com.launch.mapper;

import com.launch.template.service.model.ServiceUser;
import org.mapstruct.Mapper;
import com.launch.model.CreateUserRequest;
import com.launch.model.UpdateUserRequest;

@Mapper(componentModel = "cdi")
public interface UserRequestMapper {
    ServiceUser mapCreateRequest(CreateUserRequest request);
    ServiceUser mapUpdateRequest(UpdateUserRequest request);
}