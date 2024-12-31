package com.base.template.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.template.dto.UserInfo;
import com.base.template.entity.User;
import com.base.template.repository.UserRespository;

@Service
public class UserService {

    final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Transactional
    public boolean signIn(UserInfo userInfo) {
        UserInfo findUser = this.getUserInfo(userInfo);
        if (findUser != null) {
            return false;
        }

        User user = userInfo.toEntity();
        userRespository.save(user);

        return true;
    };

    public void signOut(UserInfo user) {
        // userRespository.signOut(user);
    };

    public UserInfo getUserInfo(UserInfo user) {
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
