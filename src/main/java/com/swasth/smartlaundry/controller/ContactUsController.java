package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.entity.ContactUs;
import com.swasth.smartlaundry.services.ContactusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "ContactUs Service")
@RequestMapping("contactus")
public class ContactUsController {

	@Autowired
	private ContactusService contactusService;
	
	@PostMapping
	public String fetchAllItemsWithPrice(@ModelAttribute ContactUs contactUs) throws Exception {
		return contactusService.updateContactusInfo(contactUs);
	}

}
