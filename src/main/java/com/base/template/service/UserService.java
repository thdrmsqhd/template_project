package com.base.template.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.template.dto.UserInfo;
import com.base.template.repository.UserRespository;

@Service
public class UserService {

    final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public void signIn(UserInfo user) {
        // userRespository.signIn(user);
    };

    public void signOut(UserInfo user) {
        // userRespository.signOut(user);
    };

    public Map<String, Object> getUserInfo(UserInfo user) {
        // return userRespository.getUserInfo(user);
        return null;
    };

    public void updateInfo(UserInfo user) {
        // userRespository.updateInfo(user);
    };

    public void getUserRole(UserInfo user) {
        // userRespository.getUserRole(user);
    };

    public boolean logIn(UserInfo user) {
        // userRespository.logIn(user);
        return false;
    };

    public boolean logOut(UserInfo user) {
        // userRespository.logOut(user);
        return false;
    };

}
