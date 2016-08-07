package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.somnus.domain.Account;

@Controller
@SessionAttributes(value = "account")
public class SessionAttributesController {
	
	@RequestMapping(value="/sessionAttributes", method = {RequestMethod.GET})
	public String sessionAttributes(){
		return "sessionAttributes";
	}
	
	@RequestMapping(value="/sessionAttributes", method = {RequestMethod.POST})
	public String sessionAttributes(Model model, Account account){
		System.out.println(account);
		model.addAttribute("account",account);
		return "sessionAttributesResult";
	}
	
}