package com.facebook.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityMappingController {

	final static Logger logger = Logger.getLogger(SecurityMappingController.class);
	
	@RequestMapping(value="/gotoLoginPage")
	public String openLoginPage() {
		logger.info("Entered into openLoginPage :: method");
		return "login";
	}
	
	@RequestMapping(value="/gotoFailurePage")
	public String openLoginPageForFail(Model model) {
		logger.info("Entered into gotoFailurePage :: method");
		
		model.addAttribute("message", "Invalid Credentials!! Please try again!!");
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String gotoHome() {
		logger.info("Entered into gotoHome :: method");
		return "Home";
	}
}
