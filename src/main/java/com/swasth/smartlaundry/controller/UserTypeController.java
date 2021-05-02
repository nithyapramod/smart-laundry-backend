package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "User Type Service")
@RequestMapping("userTypes")
public class UserTypeController {

	@Autowired
	private UserTypeService userTypeService;;

	@GetMapping
	public Response fetchAllUserTypes() throws Exception {
		return userTypeService.getAllUserTypes();
	}

}
