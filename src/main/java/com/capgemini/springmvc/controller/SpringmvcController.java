package com.capgemini.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringmvcController {
	
	@RequestMapping(path="/welcome", method=RequestMethod.GET)
	public ModelAndView getWelcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/views/welcome.jsp");
		return modelAndView;
	}
	
	@RequestMapping(path="/message", method=RequestMethod.GET)
	public ModelAndView getMessagePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/views/messagePage.jsp");
		modelAndView.addObject("msg", "Hello Wlcome to Spring MVC");
		return modelAndView;
	}
}// end of class
