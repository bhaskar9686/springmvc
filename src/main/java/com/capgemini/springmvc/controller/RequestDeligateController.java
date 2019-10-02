package com.capgemini.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligateController {
	
	@GetMapping("/forward")
	public String forwardReq() {
		return "forward:/loginForm";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
	}
}
