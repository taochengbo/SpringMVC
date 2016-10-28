package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "account")
@RequestMapping(value = "session")
public class SessionAttributesController {
	
	@RequestMapping(value="sessionAttributes", method = {RequestMethod.GET})
	public String sessionAttributes(){
		return "sessionAttributes";
	}
	
	@RequestMapping(value="sessionAttributes", method = {RequestMethod.POST})
	public String sessionAttributes(Model model, Account account){
		System.out.println(account);
		model.addAttribute("account",account);
		return "sessionAttributesResult";
	}
	
	
public static class Account{
		
		private String username;
		
		private String password;
		
		public Account(){}
		
		public void setUsername(String username){
			this.username=username;
		}
		public void setPassword(String password){
			this.password=password;
		}
		
		public String getUsername(){
			return this.username;
		}
		public String getPassword(){
			return this.password;
		}
		
		@Override
		public String toString() {
			return "account:{"+username+"|"+password+"}";
		}
		
	}
	
}