package com.swasth.smartlaundry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.swasth.smartlaundry.model.UserModel;
import com.swasth.smartlaundry.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody UserModel user) {
		return userService.handleLogin(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/validateotp/{phnumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateOtp(@PathVariable("phnumber") String phnumber) {
		return userService.handleOtp(phnumber);	
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/signup", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserModel signup(@RequestBody UserModel user) {
		return userService.handleSignup(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/forgetpassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserModel forgetPassword(@RequestBody UserModel user) {
		return userService.handleForgetPassword(user);
	}
	
}
