package com.base.template.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.template.dto.UserInfo;
import com.base.template.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Boolean> signIn(UserInfo user) {
        userService.signIn(user);
        return ResponseEntity.ok(true);
    };

    public void signOut(UserInfo user) {
        userService.signOut(user);
    };

    public Map<String, Object> getUserInfo(UserInfo user) {
        return userService.getUserInfo(user);
    };

    public void updateInfo(UserInfo user) {
        userService.updateInfo(user);
    };

    public void getUserRole(UserInfo user) {
        userService.getUserRole(user);
    };

    public boolean logIn(UserInfo user) {
        userService.logIn(user);
        return false;
    };

    public boolean logOut(UserInfo user) {
        userService.logOut(user);
        return false;
    };

}
