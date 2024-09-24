package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/authenticate")
	public ModelAndView validateUser(@RequestParam("username")String username, @RequestParam("password")String password) {
		if ( username != null && username.length() > 0 && username.equalsIgnoreCase("System"))	{
			if ( password != null && password.length() > 0 && password.equals("manager")) {
				return new ModelAndView("success", "username", username);
			}
			else {
				return new ModelAndView("failure");
			}
		}
		else {
			return new ModelAndView("failure");
		}
	}

}
