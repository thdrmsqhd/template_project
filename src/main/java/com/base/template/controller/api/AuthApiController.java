package com.base.template.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.template.domain.ResponseCode;
import com.base.template.dto.BaseResponseDto;
import com.base.template.dto.UserInfo;
import com.base.template.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponseDto> login(@RequestBody UserInfo user) {
        UserInfo loginUser = authService.login(user);
        return ResponseEntity.ok(
                BaseResponseDto.of(
                        ResponseCode.SUCCESS,
                        ResponseCode.SUCCESS.getMessage(),
                        loginUser));
    }

    @PostMapping("/register")
    public String register() {
        return "Registration successful";
    }
}