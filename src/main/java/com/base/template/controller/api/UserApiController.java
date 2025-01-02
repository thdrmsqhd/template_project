package com.base.template.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.template.domain.ResponseCode;
import com.base.template.dto.BaseResponseDto;
import com.base.template.dto.UserInfo;
import com.base.template.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserApiController {

    final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-in")
    @ResponseBody
    public ResponseEntity<BaseResponseDto> signIn(@RequestBody UserInfo user) {
        boolean successSignIn = userService.signIn(user);
        return ResponseEntity.ok(
                BaseResponseDto.of(
                        ResponseCode.SUCCESS,
                        ResponseCode.SUCCESS.getMessage(),
                        successSignIn));
    };

    @PostMapping("/sign-out")
    public void signOut(UserInfo user) {
        userService.signOut(user);
    };

    @PostMapping("get-user-info")
    public UserInfo getUserInfo(UserInfo user) {
        return null;
    };

    @PostMapping("update-info")
    public void updateInfo(UserInfo user) {
        userService.updateInfo(user);
    };

    @PostMapping("get-user-role")
    public void getUserRole(UserInfo user) {
        userService.getUserRole(user);
    };
}
