package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.Login;
import com.swasth.smartlaundry.entity.User;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response login(@RequestBody Login login) {
        return userService.login(login);
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response signUp (@RequestBody Login login) {
        return userService.signup(login);
    }

}
