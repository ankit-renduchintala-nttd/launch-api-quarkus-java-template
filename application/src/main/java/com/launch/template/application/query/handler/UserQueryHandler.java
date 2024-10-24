package com.launch.template.application.query.handler;

import com.launch.template.application.query.model.UserQuery;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.domain.repository.UserDataService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
@RequiredArgsConstructor
public class UserQueryHandler extends QueryHandlerBase<UserQuery, UserEntity> {
    final Logger logger = LogManager.getLogger(UserQueryHandler.class);

    private final UserDataService userRepository;

    @Override
    public UserEntity handle(UserQuery query) {
        logger.info("Started handling the query request");
        UserEntity order = userRepository.getUserByUsername(query.getUsername());
        logger.info("Completed handling the query request");
        return order;    }
}
