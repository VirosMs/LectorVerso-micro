package org.virosms.lectorversomicro.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.virosms.lectorversomicro.entity.User;
import org.virosms.lectorversomicro.entity.dto.UserDTO;
import org.virosms.lectorversomicro.errors.LVException;
import org.virosms.lectorversomicro.errors.LectorVersoExceptions;
import org.virosms.lectorversomicro.mapper.UserMapper;
import org.virosms.lectorversomicro.repository.UserRepository;
import org.virosms.lectorversomicro.utils.Utils;

import java.util.Objects;

@Service
@Transactional
@Validated
public class UserService {

    private static final Logger Logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    /**
     * Create a new user
     *
     * @param user User
     * @return ResponseEntity<?>
     * @throws LVException a personalized exception
     */
    public ResponseEntity<?> createUser(User user) throws LVException {
        Logger.info("UserService.createUser - ***INICIO***");

        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

        if (user == null || user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            Logger.error("UserService.createUser - Error: User is null");
            throw LVException.of(LectorVersoExceptions.PARAMETER_REQUIRED).parameter(methodName);
        }

        Logger.info("UserService.createUser - Entry param: {}", user.toString());

        Boolean exists = user.getId() != null ? userRepository.existsById(user.getId()) : null;
        boolean existsName = userRepository.existsByName(user.getName());
        boolean existsEmail = userRepository.existsByEmail(user.getEmail());


        if (exists != null && exists || existsName || existsEmail) {
            Logger.error("UserService.createUser - Error: User already exists");
            throw LVException.of(LectorVersoExceptions.USER_ALREADY_EXISTS).parameter(methodName);
        }

        var passwordHasred = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());

        user.setPassword(passwordHasred);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            Logger.error("UserService.createUser - Error: {}", e.getMessage());
            throw LVException.of(LectorVersoExceptions.USER_NOT_CREATED).parameter(methodName);
        }

        Logger.info("UserService.createUser - ***FIN+**");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * Get a user by name
     *
     * @param name     String
     * @param password String
     * @return User
     */
    public ResponseEntity<UserDTO> getUserByName(String name, String password) throws LVException {
        Logger.info("UserService.getUserByUserName - ***INICIO***");

        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

        if (name == null || password == null) {
            Logger.error("UserService.getUserByName - Error: User is null");
            throw LVException.of(LectorVersoExceptions.PARAMETER_REQUIRED).parameter(methodName);
        }

        if(Utils.isValidUsername(name)) {
            Logger.error("UserService.getUserByName - Error: Invalid username");
            throw LVException.of(LectorVersoExceptions.INVALID_USERNAME).parameter(methodName);
        }

        Logger.info("UserService.getUserByName - Entry param: {}", name);

        User user = userRepository.findByName(name);

        if (user == null) {
            Logger.error("UserService.getUserByName - Error: User not found");
            throw LVException.of(LectorVersoExceptions.USER_NOT_FOUND).parameter(methodName);
        }

        var passwordHasred = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

        if (!passwordHasred.verified) {
            Logger.error("UserService.getUserByName - Error: Invalid user");
            throw LVException.of(LectorVersoExceptions.USER_INVALID).parameter(methodName);
        }

        UserDTO userDTO;
        try {
            userDTO = userMapper.toUserDTO(user);
        } catch (Exception e) {
            Logger.error("UserService.getUserByName - Error: {}", e.getMessage());
            throw LVException.of(LectorVersoExceptions.ERROR_TO_MAPPING_USER).parameter(methodName);
        }

        if (userDTO == null) {
            Logger.error("UserService.getUserByName - Error: User not found");
            throw LVException.of(LectorVersoExceptions.ERROR_CANNOT_BE_NULL).parameter(methodName);
        }

        Logger.info("UserService.getUserByUserName - ***FIN+**");

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    /**
     * Get a user by email
     *
     * @param email    String
     * @param password String
     * @return User
     */
    public ResponseEntity<UserDTO> getUserByEmail(String email, String password) throws LVException {
        Logger.info("UserService.getUserByEmail - ***INICIO***");

        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

        if (email == null || password == null) {
            Logger.error("UserService.getUserByEmail - Error: User is null");
            throw LVException.of(LectorVersoExceptions.PARAMETER_REQUIRED).parameter(methodName);
        }

        Logger.info("UserService.getUserByEmail - Entry param: {}", email);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            Logger.error("UserService.getUserByEmail - Error: User not found");
            throw LVException.of(LectorVersoExceptions.USER_NOT_FOUND).parameter(methodName);
        }

        var passwordHasred = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

        if (!passwordHasred.verified) {
            Logger.error("UserService.getUserByEmail - Error: Invalid user");
            throw LVException.of(LectorVersoExceptions.USER_INVALID).parameter(methodName);
        }

        UserDTO userDTO;
        try {
            userDTO = userMapper.toUserDTO(user);
        } catch (Exception e) {
            Logger.error("UserService.getUserByEmail - Error: {}", e.getMessage());
            throw LVException.of(LectorVersoExceptions.ERROR_TO_MAPPING_USER).parameter(methodName);
        }

        if (userDTO == null) {
            Logger.error("UserService.getUserByEmail - Error: User not found");
            throw LVException.of(LectorVersoExceptions.ERROR_CANNOT_BE_NULL).parameter(methodName);
        }

        Logger.info("UserService.getUserByEmail - ***FIN+**");
        var response = new ResponseEntity<>(userDTO, HttpStatus.OK);
        Logger.info("UserService.getUserByEmail - Response Body: {} -- Response HttpCode: {}", response.getBody(),
                response.getStatusCode());

        return response;
    }


    /**
     * Delete a user by email
     */
    public ResponseEntity<?> deleteUser(String email, String password) throws LVException {
        Logger.info("UserService.deleteUser - ***INICIO***");

        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();

        if (email == null) {
            Logger.error("UserService.deleteUser - Error: User is null");
            throw LVException.of(LectorVersoExceptions.PARAMETER_REQUIRED).parameter(methodName);
        }

        Logger.info("UserService.deleteUser - Entry param: {}", email);

        if (!userRepository.existsByEmail(email)) {
            Logger.error("UserService.deleteUser - Error: User not found to delete");
            throw LVException.of(LectorVersoExceptions.USER_NOT_FOUND).parameter(methodName);
        }

        var userDTO = getUserByEmail(email, password);

        try {
            userRepository.deleteByEmail(Objects.requireNonNull(userDTO.getBody()).email());
        } catch (Exception e) {
            Logger.error("UserService.deleteUser - Error: {}", e.getMessage());
            throw LVException.of(LectorVersoExceptions.USER_NOT_DELETED).parameter(methodName);
        }


        if (userRepository.existsByEmail(email)) {
            Logger.error("UserService.deleteUser - Error: User not found to delete");
            throw LVException.of(LectorVersoExceptions.USER_NOT_DELETED_NOT_FOUND).parameter(methodName);
        }

        Logger.info("UserService.deleteUser - ***FIN+**");

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
