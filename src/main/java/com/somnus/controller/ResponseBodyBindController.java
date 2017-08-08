package com.somnus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "response")
public class ResponseBodyBindController {
	
	@RequestMapping(value="responsebodybind", method = {RequestMethod.GET})
    public String requestBodyBind(){
        return "responsebodybind";
    }

	@RequestMapping(value="responsebodybind", method = {RequestMethod.POST})
	@ResponseBody
    public Account responsebodybind(Account account){
		System.out.println("responsebodybind:" + account);
		return account;
    }
	
	@RequestMapping(value="responsebodybind2", method = {RequestMethod.POST})
    @ResponseBody
    public Account responsebodybind(String username,String password){
	    Account account = new Account();
	    account.setUsername(username);
	    account.setPassword(password);
	    System.out.println("responsebodybind2:" + account);
        return account;
    }
	
	@RequestMapping(value="responsebodybind3"/*, produces="application/json"*/)
    @ResponseBody/* 默认 application/json*/
    public Account responsebodybind(){
	    Account account = new Account("admin", "123456");
	    System.out.println("responsebodybind3:" + account);
        return account;
    }
	
	@RequestMapping(value="responsebodybind4", produces="application/xml")
    @ResponseBody/* 也需要依赖对应的jar包*/
    public Account responsebodybind4(){
	    Account account = new Account("admin", "123456");
	    System.out.println("responsebodybind4:" + account);
        return account;
    }
	
	@RequestMapping(value="simple", method = {RequestMethod.GET})
    @ResponseBody
    public String simple(){
        return "abc中国";
    }
	
	@RequestMapping(value="complex", method = {RequestMethod.GET})
    @ResponseBody
    public String complex(){
	    String result = JSON.toJSONString(new Account("abc中国", "123456"));
        return result;
    }
	
	@RequestMapping(value="complex2", method = {RequestMethod.GET})
    @ResponseBody
    public List<String> complex2(){
        return Arrays.asList("壹","贰","叁");
    }
	
	
	
public class Account{
		
		private String username;
		
		private String password;
		
		public Account(){}
		
		
		public Account(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

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