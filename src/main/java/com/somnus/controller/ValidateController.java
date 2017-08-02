package com.somnus.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/**
	 * @Validated和@Valid 在这里都可以
	 * @param validateModel
	 * @return
	 */
	@RequestMapping(value="test", method = {RequestMethod.POST})
	@ResponseBody
	public ValidateModel test(@Valid @ModelAttribute("contentModel") ValidateModel model, BindingResult result){
		
		if(result.hasErrors()){
			for(int i = 0;i<result.getFieldErrorCount();i++){
				FieldError error = result.getFieldErrors().get(i);
				System.out.println(error.getField() + "-->" + error.getDefaultMessage());
			}
        }
		
    	return model;
	}
	
	/**
	 * 不加BindingResult会报异常如下：
	 * org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument at index 0 in method: 
	 * public com.somnus.controller.ValidateModel 
	 * com.somnus.controller.ValidateController.test2(com.somnus.controller.ValidateModel), 
	 * with 2 error(s): [Field error in object 'validateModel' on field 'email': rejected value [null]; 
	 * codes [NotEmpty.validateModel.email,NotEmpty.email,NotEmpty.java.lang.String,NotEmpty]; 
	 * arguments [org.springframework.context.support.DefaultMessageSourceResolvable: 
	 * codes [validateModel.email,email]; arguments []; default message [email]]; 
	 * default message [电子邮件不能为空。]] [Field error in object 'validateModel' on field 'age': rejected value [2222]; 
	 * codes [Range.validateModel.age,Range.age,Range.java.lang.String,Range]; 
	 * arguments [org.springframework.context.support.DefaultMessageSourceResolvable: 
	 * codes [validateModel.age,age]; arguments []; default message [age],150,0]; default message [年龄超出范围。]] 
	 * 
	 * at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:135)
	 * 
	 * @Validated和@Valid 在这里都可以
	 */
	@RequestMapping(value="test2", method = {RequestMethod.POST})
	@ResponseBody
	public ValidateModel test2(@Validated @RequestBody ValidateModel model, BindingResult result){
		
		if(result.hasErrors()){
			for(int i = 0;i<result.getFieldErrorCount();i++){
				FieldError error = result.getFieldErrors().get(i);
				System.out.println(error.getField() + "-->" + error.getDefaultMessage());
			}
        }
		
    	return model;
	}
	
}
class ValidateModel{
	
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
