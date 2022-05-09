package com.service.demo.demo.controler;


import com.service.demo.demo.converter.UserConverter;
import com.service.demo.demo.dto.user.UserResponse;
import com.service.demo.demo.dto.user.UserSaveRequest;
import com.service.demo.demo.entity.User;
import com.service.demo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public ResponseEntity<Set<User>>findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserSaveRequest userSaveRequest){
        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

}
