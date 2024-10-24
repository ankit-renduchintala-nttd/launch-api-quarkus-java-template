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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserApiServiceImplTest {

    @Mock
    private UserQueryHandler userQueryHandler;

    @Mock
    private UsersQueryHandler usersQueryHandler;

    @Mock
    private CreateUserCommandHandler createUserCommandHandler;

    @Mock
    private UpdateUserCommandHandler updateUserCommandHandler;

    @Mock
    private DeleteUserCommandHandler deleteUserCommandHandler;

    @InjectMocks
    private UserApiServiceImpl userApiService;


    @Test
    void createUserSuccessfully() {
        ServiceUser user = new ServiceUser();
        user.setUsername("testUser");
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testUser");
        userEntity.setName("Test User");
        userEntity.setEmail("testuser@example.com");

        when(createUserCommandHandler.handle(any(CreateUserCommand.class))).thenReturn(userEntity);

        UserEntity result = userApiService.createUser(user);

        assertEquals(userEntity, result);
        verify(createUserCommandHandler, times(1)).handle(any(CreateUserCommand.class));
    }

    @Test
    void deleteUserSuccessfully() {
        String username = "testUser";

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testUser");
        userEntity.setName("Test User");
        userEntity.setEmail("testuser@example.com");

        when(deleteUserCommandHandler.handle(any(DeleteUserCommand.class))).thenReturn(userEntity);

        UserEntity result = userApiService.deleteUser(username);

        assertEquals(userEntity, result);
        verify(deleteUserCommandHandler, times(1)).handle(any(DeleteUserCommand.class));
    }

    @Test
    void getAllUsersSuccessfully() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testUser");
        userEntity.setName("Test User");
        userEntity.setEmail("testuser@example.com");

        when(usersQueryHandler.handle(any(UsersQuery.class))).thenReturn(Collections.singletonList(userEntity));

        List<UserEntity> result = userApiService.getAllUsers();

        assertEquals(1, result.size());
        assertEquals(userEntity, result.get(0));
        verify(usersQueryHandler, times(1)).handle(any(UsersQuery.class));
    }

    @Test
    void getUserSuccessfully() {
        String username = "testUser";

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testUser");
        userEntity.setName("Test User");
        userEntity.setEmail("testuser@example.com");

        when(userQueryHandler.handle(any(UserQuery.class))).thenReturn(userEntity);

        UserEntity result = userApiService.getUser(username);

        assertEquals(userEntity, result);
        verify(userQueryHandler, times(1)).handle(any(UserQuery.class));
    }

    @Test
    void updateUserSuccessfully() {
        String username = "testUser";
        ServiceUser user = new ServiceUser();
        user.setUsername("testUser");
        user.setName("Updated User");
        user.setEmail("updateduser@example.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testUser");
        userEntity.setName("Updated User");
        userEntity.setEmail("updateduser@example.com");

        when(updateUserCommandHandler.handle(any(UpdateUserCommand.class))).thenReturn(userEntity);

        UserEntity result = userApiService.updateUser(username, user);

        assertEquals(userEntity, result);
        verify(updateUserCommandHandler, times(1)).handle(any(UpdateUserCommand.class));
    }
}