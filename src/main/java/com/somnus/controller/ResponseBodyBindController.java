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
    public Account responsebodybind2(String username,String password){
	    Account account = new Account(username,password);
	    System.out.println("responsebodybind2:" + account);
        return account;
    }
	
	@RequestMapping(value="returnjson", headers="Accept=application/json")
    @ResponseBody
    public Account returnjson(){
	    Account account = new Account("admin", "123456");
	    System.out.println("returnjson:" + account);
        return account;
    }
	
	@RequestMapping(value="returnxml", headers="Accept=application/xml")
    @ResponseBody
    public Account returnxml(){
	    Account account = new Account("admin", "123456");
	    System.out.println("returnxml:" + account);
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
	
}
