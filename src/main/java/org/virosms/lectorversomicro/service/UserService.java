package org.virosms.lectorversomicro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.virosms.lectorversomicro.entity.User;
import org.virosms.lectorversomicro.errors.LVException;
import org.virosms.lectorversomicro.errors.LectorVersoExceptions;
import org.virosms.lectorversomicro.repository.UserRepository;

@Service
@Transactional
@Validated
public class UserService {

    private static final Logger Logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    UserService() {
    }

    public ResponseEntity<?> createUser(User user) throws LVException {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();

        if (user == null) {
            Logger.error("UserService.createUser - Error: User is null");
            throw LVException.of(LectorVersoExceptions.PARAMETER_REQUIRED).parameter(methodName);
        }

        Logger.info("UserService.createUser - Entry param: {}", user.toString());

        boolean exists = userRepository.existsById(user.getId());

        if (exists) {
            Logger.error("UserService.createUser - Error: User already exists");
            throw LVException.of(LectorVersoExceptions.USER_ALREADY_EXISTS).parameter(methodName);
        }

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
