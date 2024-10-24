package com.launch.template.application.command.handler;

import com.launch.template.application.command.model.DeleteUserCommand;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.domain.repository.UserDataService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
@RequiredArgsConstructor
public class DeleteUserCommandHandler extends CommandHandlerBase<DeleteUserCommand, UserEntity> {

    final Logger logger = LogManager.getLogger(DeleteUserCommandHandler.class);


    UserDataService userRepository;

    @Override
    public UserEntity handle(DeleteUserCommand command) {
        logger.info("Started processing user");
        UserEntity userEntity = userRepository.delete(command.getUsername());
        logger.info("Competed processing user");
        return userEntity;
    }
}
