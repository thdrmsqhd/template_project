package com.base.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.template.dto.UserInfo;
import com.base.template.entity.User;
import com.base.template.repository.UserRespository;

@Service
public class UserService {

    @Autowired
    UserRespository userRespository;

    @Transactional
    public boolean signIn(UserInfo userInfo) {
        User findUser = this.getUserInfo(userInfo);
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

    public User getUserInfo(UserInfo user) {
        return userRespository.findByUserId(user.getEmail());
    };

    public void updateInfo(UserInfo user) {
        // userRespository.updateInfo(user);
    };

    public void getUserRole(UserInfo user) {
        // userRespository.getUserRole(user);
    };

}
