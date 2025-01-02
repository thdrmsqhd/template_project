package com.base.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.template.dto.UserInfo;
import com.base.template.entity.User;
import com.base.template.repository.UserRespository;

@Service
public class AuthService {

    @Autowired
    UserRespository userRepository;

    public UserInfo login(UserInfo user) {
        User findUser = userRepository.findByUserId(user.getEmail());
        if (findUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!findUser.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Password is incorrect");
        }

        return UserInfo.toDto(findUser);

    }

}
