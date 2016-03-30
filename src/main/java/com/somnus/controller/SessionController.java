package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.somnus.domain.Account;

@Controller
@RequestMapping(value = "/session")
@SessionAttributes(value = "sessionAccount")
public class SessionController {
	
	@RequestMapping(value="/usernamebind", method = {RequestMethod.GET})
	public String userNameBind(Model model){
		
		model.addAttribute("sessionAccount", new Account());
		return "usernamebind";
	}
	
	@RequestMapping(value="/usernamebind", method = {RequestMethod.POST})
	public String userNameBindPost(@ModelAttribute("sessionAccount") Account account){
		System.out.println(account);
		//重定向到密码绑定测试
		return "redirect:passwordbind";
	}
	
	@RequestMapping(value="/passwordbind", method = {RequestMethod.GET})
	public String passwordBind(@ModelAttribute("sessionAccount") Account account){
	    System.out.println(account);
		return "passwordbind";
	}
	
	@RequestMapping(value="/passwordbind", method = {RequestMethod.POST})
	public String passwordBindPost(@ModelAttribute("sessionAccount")Account account, 
	        SessionStatus status){
	    System.out.println(account);
		//销毁@SessionAttributes中value指定名称的数据
		status.setComplete();
		//显示绑定结果
		return "sessionmodelbindresult";
	}
	
	@ModelAttribute("sessionAccount")
    public Account initAccount(){
        return new Account();
    }
		
}