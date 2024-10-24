package com.launch.template.service.delegate;

import com.launch.template.application.command.handler.CreateUserCommandHandler;
import com.launch.template.application.command.handler.DeleteUserCommandHandler;
import com.launch.template.application.command.handler.UpdateUserCommandHandler;
import com.launch.template.application.command.model.CreateUserCommand;
import com.launch.template.application.command.model.DeleteUserCommand;
import com.launch.template.application.command.model.UpdateUserCommand;
import com.launch.template.application.query.handler.UserQueryHandler;
import com.launch.template.application.query.handler.UsersQueryHandler;
import com.launch.template.application.query.model.UserQuery;
import com.launch.template.application.query.model.UsersQuery;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.service.model.ServiceUser;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
@Log4j2
public class UserApiServiceImpl implements UserApiService {
    private final UserQueryHandler userQueryHandler;
    private final UsersQueryHandler usersQueryHandler;
    private final CreateUserCommandHandler createUserCommandHandler;
    private final UpdateUserCommandHandler updateUserCommandHandler;
    private final DeleteUserCommandHandler deleteUserCommandHandler;

    @Override
    public UserEntity createUser(ServiceUser user) {

        log.info("Creating user");
        CreateUserCommand createUserCommand = CreateUserCommand.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .build();
        return createUserCommandHandler.handle(createUserCommand);
    }


    @Override
    public UserEntity deleteUser(String username) {
        log.info("Deleting user");
        DeleteUserCommand deleteUserCommand = DeleteUserCommand.builder()
                .username(username)
                .build();
        return deleteUserCommandHandler.handle(deleteUserCommand);
    }

    @Override
    public List<UserEntity> getAllUsers() {

        log.info("Getting all users");
        UsersQuery usersQuery = UsersQuery.builder()
                .build();
        return usersQueryHandler.handle(usersQuery);
    }

    @Override
    public UserEntity getUser(String username) {
        log.info("Getting details for user");
        UserQuery userQuery = UserQuery.builder()
                .username(username)
                .build();
        return userQueryHandler.handle(userQuery);
    }

    @Override
    public UserEntity updateUser(String username, ServiceUser updateUserRequest) {
        log.info("Updating details for user");
        UpdateUserCommand updateUserCommand = UpdateUserCommand.builder()
                .username(username)
                .name(updateUserRequest.getName())
                .email(updateUserRequest.getEmail())
                .build();
        return updateUserCommandHandler.handle(updateUserCommand);
    }
}