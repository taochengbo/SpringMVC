package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(value = "account")
@RequestMapping(value = "ma")
public class ModelAttributeController {
	
	@RequestMapping(value="modelAttribute1", method = {RequestMethod.GET})
	public String modelAttribute(){
		return "modelAttribute1";
	}
	
	@RequestMapping(value="modelAttribute2username", method = {RequestMethod.POST})
	public String modelAttribute2username(Account account){
		System.out.println("modelAttribute2username->" + account);
		return "redirect:modelAttribute2";
	}
	
	@RequestMapping(value="modelAttribute2", method = {RequestMethod.GET})
	public String passwordBind(@ModelAttribute("account")Account account){
	    System.out.println("modelAttribute2->" + account);
		return "modelAttribute2";
	}
	
	@RequestMapping(value="modelAttribute2password", method = {RequestMethod.POST})
	public String modelAttribute2password(@ModelAttribute("account")Account account, 
	        SessionStatus status){
	    System.out.println("modelAttribute2password->" + account);
		//销毁@SessionAttributes中value指定名称的数据
		status.setComplete();
		//显示绑定结果
		return "modelAttributeresult";
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