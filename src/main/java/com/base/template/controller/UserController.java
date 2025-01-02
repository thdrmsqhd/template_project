package com.base.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/login")
    public String logInPage(UserInfo user) {
        return "login";
    };
}
