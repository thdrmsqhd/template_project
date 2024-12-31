package com.base.template.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.template.dto.UserInfo;
import com.base.template.service.UserService;

@Controller
@RequestMapping("/user/api")
public class UserApiController {

    final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    @ResponseBody
    public ResponseEntity<Boolean> signIn(@RequestBody UserInfo user) {
        boolean successSignIn = userService.signIn(user);
        return ResponseEntity.ok(successSignIn);
    };

    @PostMapping("/sign-out")
    public void signOut(UserInfo user) {
        userService.signOut(user);
    };

    @PostMapping("get-user-info")
    public UserInfo getUserInfo(UserInfo user) {
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
