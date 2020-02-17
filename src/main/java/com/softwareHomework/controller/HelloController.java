package com.softwareHomework.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public JSONObject helloWorld(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "Hello Yourself");
		
		return jsonObject;
	}

}
