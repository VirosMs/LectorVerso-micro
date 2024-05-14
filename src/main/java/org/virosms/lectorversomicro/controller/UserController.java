package org.virosms.lectorversomicro.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.virosms.lectorversomicro.entity.User;
import org.virosms.lectorversomicro.errors.LVException;
import org.virosms.lectorversomicro.service.UserService;

@RestController
@RequestMapping("/lv/api/u")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger Logger = LogManager.getLogger(UserController.class);

    @GetMapping("/user/{id}")
    public RequestEntity<User> getUserById(@PathVariable("id") Long id) {
        Logger.info("UserController.getUserById - Entry param: {}", id);
        return null;
    }

    @GetMapping("/user/{name}")
    public RequestEntity<User> getUserByUserName(@PathVariable("name") String name) {
        Logger.info("UserController.getUserByUserName - Entry param: {}", name);
        return null;
    }

    @GetMapping("/user/")
    public ResponseEntity<?> createUser(@RequestBody User user) throws LVException {
        Logger.info("UserController.createUser - Entry param: {}", user.toString());
        return userService.createUser(user);
    }

    @GetMapping("/user/update/")
    public RequestEntity<?> updateUser(@RequestBody User user) {
        Logger.info("UserController.updateUser - Entry param: {}", user.toString());
        return null;
    }

    @GetMapping("/user/delete/{id}")
    public RequestEntity<?> deleteUser(@PathVariable("id") Long id) {
        Logger.info("UserController.deleteUser - Entry param: {}", id);

        return null;
    }



}
