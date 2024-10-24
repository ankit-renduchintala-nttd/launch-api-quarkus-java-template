package com.launch.template.application.query.handler;

import com.launch.template.application.query.model.UsersQuery;
import com.launch.template.domain.entity.UserEntity;
import com.launch.template.domain.repository.UserDataService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
@Log4j2
public class UsersQueryHandler extends QueryHandlerBase<UsersQuery, List<UserEntity>> {
    private final UserDataService userRepository;

    @Override
    public List<UserEntity> handle(UsersQuery query) {
        log.info("Started handling the query request");
        List<UserEntity> userEntities = userRepository.getAll();
        log.info("Completed handling the query request");
        return userEntities;
    }
}
