package com.swasth.smartlaundry.controller;

import com.swasth.smartlaundry.model.Response;
import com.swasth.smartlaundry.services.PaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Payment Methods Service")
@RequestMapping("paymentMethod")
public class PaymentMethodController {

	@Autowired
	private PaymentMethodsService paymentMethodsService;;

	@GetMapping
	public Response fetchPaymentMethods() throws Exception {
		return paymentMethodsService.getPaymentMethods();
	}

}
