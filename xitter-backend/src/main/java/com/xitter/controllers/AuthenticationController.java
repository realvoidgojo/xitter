package com.xitter.controllers;

import com.xitter.models.ApplicationUser;
import com.xitter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService){
        this.userService = userService;
    }
    // got to http://localhost:8000/auth/register
    @PostMapping("/register")
    public ApplicationUser resgisterUser(@RequestBody ApplicationUser user){
        return userService.registerUser(user);
    }

}
