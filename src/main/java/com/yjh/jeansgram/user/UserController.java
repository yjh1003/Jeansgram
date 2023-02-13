package com.yjh.jeansgram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping("/signup/view")
	public String signupView() {
		
		return "user/signup";
	}
	
	@GetMapping("/signin/view")
	public String signinView() {
		
		return "user/signin";
	}
	
	
}
