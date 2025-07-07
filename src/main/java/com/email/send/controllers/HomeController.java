package com.email.send.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/msg")
	public String someMessage() {
		return "WELCOME TO EMAIL SENDER APPLICATION";
	}
	
//	email.server ka host dalna haui
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
}
