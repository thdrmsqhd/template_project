package com.base.template.dto;

import com.base.template.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String email;
    private String password;

    public static UserInfo toDto(User userInfo) {
        return new UserInfo(userInfo.getUserId(), userInfo.getPassword());
    }

    public User toEntity() {
        return new User(this.email, this.password);
    }
}
