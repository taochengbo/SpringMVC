package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somnus.domain.Account;

@Controller
@RequestMapping(value = "/databind")
public class ResponseBodyBindController {
	
	@RequestMapping(value="/responsebodybind", method = {RequestMethod.GET})
    public String requestBodyBind(){
        return "responsebodybind";
    }

	@RequestMapping(value="/responsebodybind", method = {RequestMethod.POST})
	@ResponseBody
    public Account responsebodybind(Account account){
		System.out.println(account);
		return account;
    }
	
	@RequestMapping(value="/responsebodybind2", method = {RequestMethod.POST})
    @ResponseBody
    public Account responsebodybind(String username,String password){
	    Account account = new Account();
	    account.setUsername(username);
	    account.setPassword(password);
        return account;
    }
	
}