package com.service.demo.demo.dto.user;


import com.service.demo.demo.dto.role.RoleResponce;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;
    private String username;
    private RoleResponce roleResponce;

}
