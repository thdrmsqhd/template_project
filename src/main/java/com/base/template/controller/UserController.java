package com.base.template.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.template.dto.UserInfo;
import com.base.template.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String signInPage() {
        return "signin";
    }

    @PostMapping("/sign-in-action")
    @ResponseBody
    public ResponseEntity<Boolean> signIn(UserInfo user) {
        userService.signIn(user);
        return ResponseEntity.ok(true);
    };

    @PostMapping("/sign-out")
    public void signOut(UserInfo user) {
        userService.signOut(user);
    };

    @PostMapping("get-user-info")
    public Map<String, Object> getUserInfo(UserInfo user) {
        return userService.getUserInfo(user);
    };

    @PostMapping("update-info")
    public void updateInfo(UserInfo user) {
        userService.updateInfo(user);
    };

    @PostMapping("get-user-role")
    public void getUserRole(UserInfo user) {
        userService.getUserRole(user);
    };

    @GetMapping("log-in")
    public String logInPage(UserInfo user) {
        return "login";
    };

    @PostMapping("log-in")
    public ResponseEntity<Boolean> logIn(UserInfo user) {
        Boolean loginStatus = userService.logIn(user);
        return ResponseEntity.ok(loginStatus);
    };

    @PostMapping("log-out")
    public boolean logOut(UserInfo user) {
        userService.logOut(user);
        return false;
    };

}
