package com.service.demo.demo.converter;


import com.service.demo.demo.dto.role.RoleResponce;
import com.service.demo.demo.dto.user.UserResponse;
import com.service.demo.demo.dto.user.UserSaveRequest;
import com.service.demo.demo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Component
@AllArgsConstructor
public class UserConverter {

    private final RoleConverter roleConverter;

    public User convert(UserSaveRequest userSaveRequest){
        return User.builder()
                .password(userSaveRequest.getPassword())
                .username(userSaveRequest.getUsername())
                .build();
    }

    public UserResponse convert(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roleResponce(roleConverter.convert(user.getRole()))
                .build();
    }
}
