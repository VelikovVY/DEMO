package com.service.demo.demo.converter;


import com.service.demo.demo.dto.role.RoleResponce;
import com.service.demo.demo.dto.role.RoleSaveRequest;
import com.service.demo.demo.dto.role.RoleUpdateRequest;
import com.service.demo.demo.entity.Role;
import org.springframework.stereotype.Component;

@Component//registraciq v Spring conteinera

public class RoleConverter {

    public Role convert(RoleSaveRequest roleSaveRequest) {
        return Role.builder()
                .name(roleSaveRequest.getName())
                .build();
    }
    public RoleResponce convert (Role role) {
        return RoleResponce.builder()
                .name(role.getName())
                .build();
    }
    public Role convert (RoleUpdateRequest roleUpdateRequest){
        return Role.builder()
                .id(roleUpdateRequest.getId())
                .name(String.valueOf(roleUpdateRequest.getName()))///????
                .build();
    }
}
