package org.virosms.lectorversomicro.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.virosms.lectorversomicro.entity.User;
import org.virosms.lectorversomicro.entity.dto.UserDTO;
import org.virosms.lectorversomicro.errors.LVException;
import org.virosms.lectorversomicro.service.UserService;

@RestController
@RequestMapping("/lv/api/u")
@EnableWebMvc
public class UserController {


    private static final Logger Logger = LogManager.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/n")
    public ResponseEntity<UserDTO> getUserByUserName(@RequestParam("name") String name, @RequestParam("password") String paswword) throws LVException {
        Logger.info("UserController.getUserByUserName - Entry param: {}", name);
        return userService.getUserByName(name, paswword);
    }

    @GetMapping("/user/e")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam("email") String email, @RequestParam("password") String paswword) throws LVException {
        Logger.info("UserController.getUserByEmail - Entry param: {}", email);
        return userService.getUserByEmail(email, paswword);
    }

    @PostMapping("/user/")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) throws LVException {
        Logger.info("UserController.createUser - Entry param: {}", user.toString());
        return userService.createUser(user);
    }

    @DeleteMapping("/user/delete/")
    public ResponseEntity<?> deleteUser(@RequestParam("email") String email, @RequestParam("password") String password) throws LVException {
        Logger.info("UserController.deleteUser - Entry param: {}", email);
        return userService.deleteUser(email, password);
    }


}
