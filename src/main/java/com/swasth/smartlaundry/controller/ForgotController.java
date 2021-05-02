package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.ForgotPassword;
import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Forgot password Service")
@RequestMapping("forgot/password")
public class ForgotController {

	@Autowired
	private ForgotPasswordService forgotPasswordService;;

	@PostMapping
	public Response forgotPassword(@RequestBody ForgotPassword forgotPassword) throws Exception {
		return forgotPasswordService.updatePassword(forgotPassword);
	}

}
