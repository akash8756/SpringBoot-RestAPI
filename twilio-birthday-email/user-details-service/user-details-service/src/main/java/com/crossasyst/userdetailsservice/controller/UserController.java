package com.crossasyst.userdetailsservice.controller;

import com.crossasyst.userdetailsservice.Response.UserResponse;
import com.crossasyst.userdetailsservice.model.Users;
import com.crossasyst.userdetailsservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addusers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> addUsers(@RequestBody Users users){
        UserResponse userResponse=userService.addPerson(users);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }
}
