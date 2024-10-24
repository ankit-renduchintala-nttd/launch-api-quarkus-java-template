package com.launch.template.application.command.handler;

import com.launch.template.application.command.model.UpdateUserCommand;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.domain.repository.UserDataService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
@RequiredArgsConstructor
public class UpdateUserCommandHandler extends CommandHandlerBase<UpdateUserCommand, UserEntity> {

    final Logger logger = LogManager.getLogger(UpdateUserCommandHandler.class);


    private final UserDataService userRepository;

    @Override
    public UserEntity handle(UpdateUserCommand command) {
        logger.info("Started processing user");
        UserEntity existingUser = userRepository.getUserByUsername(command.getUsername());

        existingUser.setName(command.getName());
        existingUser.setEmail(command.getEmail());

        UserEntity createdUser = userRepository.update(existingUser);
        logger.info("Competed processing user");
        return createdUser;

    }

}
