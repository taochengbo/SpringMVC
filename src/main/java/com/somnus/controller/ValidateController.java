package com.somnus.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "validate")
public class ValidateController {
	
	@RequestMapping(value="test", method = {RequestMethod.GET})
	public String test(Model model){

		if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", new ValidateModel());
        }
		return "validatetest";
	}
	
	@RequestMapping(value="test", method = {RequestMethod.POST})
	public String test(Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel, 
	        BindingResult result) throws NoSuchAlgorithmException{
		
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return test(model);
    	return "validatesuccess"; 	
	}
	
	public static class ValidateModel{
		
		@NotEmpty(message="{name.not.empty}")
		private String name;
		@Range(min=0, max=150,message="{age.not.inrange}")
		private String age;
		@NotEmpty(message="{email.not.empty}")
		@Email(message="{email.not.correct}")
		private String email;
		
		public void setName(String name){
			this.name=name;
		}
		public void setAge(String age){
			this.age=age;
		}
		public void setEmail(String email){
			this.email=email;
		}
		
		public String getName(){
			return this.name;
		}
		public String getAge(){
			return this.age;
		}
		public String getEmail(){
			return this.email;
		}
		
	}
	
}
