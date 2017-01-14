package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "request")
public class RequestBodyBindController {

	@RequestMapping(value="requestbodybind", method = {RequestMethod.GET})
    public String requestBodyBind(){
        return "requestbodybind";
    }
	
	@RequestMapping(value="requestbodybind", method = {RequestMethod.POST})
	@ResponseBody
    public Account requestBodyBind(@RequestBody Account account){
		System.out.println("requestbodybind:" + account);
		return account;
    }
	
	@RequestMapping(value="requestbodybind2", method = {RequestMethod.POST})
    @ResponseBody
    public Account requestbodybind(String username,String password){
	    Account account = new Account();
	    account.setUsername(username);
	    account.setPassword(password);
	    System.out.println("requestbodybind2:" + account);
        return account;
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