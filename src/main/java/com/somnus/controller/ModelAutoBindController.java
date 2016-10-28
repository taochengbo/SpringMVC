package com.somnus.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "databind")
public class ModelAutoBindController {

	@RequestMapping(value="modelautobind", method = {RequestMethod.GET})
	public String modelAutoBind(/*Model model*/){
		//界面用到了【springmvc标签】才需要用model设置一个对象，给前端用来绑定
		/*model.addAttribute("account", new Account());*/
		return "modelautobind";
	}
	/**               以下三个方法都可以用来拿到对象后，并把对象传递到结果界面                            */
	@RequestMapping(value="modelautobind", method = {RequestMethod.POST})
	public String modelAutoBind(@ModelAttribute("account") Account account){
		System.out.println("第一种方式：" + account);
		return "modelautobindresult";
	}
	
	@RequestMapping(value="modelautobind2", method = {RequestMethod.POST,RequestMethod.GET})
	public String modelAutoBind(Model model, Account account){
		System.out.println("第二种方式：" + account);
		model.addAttribute("account", account);
		return "modelautobindresult";
	}
	
	@RequestMapping(value="modelautobind3", method = {RequestMethod.POST})
	public String modelAutoBind(HttpServletRequest request,Account account){
		System.out.println("第三种方式：" + account);
		request.setAttribute("account", account);
		return "modelautobindresult";
	}
	
	@RequestMapping(value="modelautobind4", method = {RequestMethod.POST})
	public String modelAutoBind(Map<String,Object> map, Account account){
		System.out.println("第四种方式：" + account);
		map.put("account", account);
		return "modelautobindresult";
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