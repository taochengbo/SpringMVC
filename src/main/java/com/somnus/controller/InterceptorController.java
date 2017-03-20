package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "interceptor")
public class InterceptorController {

	@RequestMapping(value="test", method = {RequestMethod.GET})
	public ModelAndView handleRequest(){
		System.out.println("===========TestController");
		return new ModelAndView("interceptor");
	}

}
