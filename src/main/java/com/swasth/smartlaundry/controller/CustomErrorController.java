package com.swasth.smartlaundry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.swasth.smartlaundry.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
//@Tag(name = "Custom Error")
public class CustomErrorController implements ErrorController {

	private static final String PATH = "error";

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping(PATH)
	@ResponseBody
	public Response error(WebRequest request, HttpServletResponse response) {
		return new Response(false,response.getStatus(), getErrorAttributes(request));
	}

	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@SuppressWarnings("deprecation")
	private Map<String, Object> getErrorAttributes(WebRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.putAll(this.errorAttributes.getErrorAttributes(request, true));
		return map;
	}
}