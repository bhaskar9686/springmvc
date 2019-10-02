package com.capgemini.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	@GetMapping("/cookiePage")
	public String getCookiePage() {
		return "cookiePage";
	}

	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp, ModelMap modelMap) {
		Cookie cookie = new Cookie("name", "Bhaskar");
		resp.addCookie(cookie);
		
		modelMap.addAttribute("msg", "Cookie Added Successfully...");

		return "cookiePage";
	}// End of createCookie()
	
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name = "name") String name, ModelMap modelMap) {
		modelMap.addAttribute("msg", "Cookie value is " + name);
		
		return "cookiePage";
	}// End of readCookie()
	

}
