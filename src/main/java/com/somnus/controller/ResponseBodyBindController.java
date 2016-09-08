package com.somnus.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
		System.out.println("responsebodybind:" + account);
		return account;
    }
	
	@RequestMapping(value="/responsebodybind2", method = {RequestMethod.POST})
    @ResponseBody
    public Account responsebodybind(String username,String password){
	    Account account = new Account();
	    account.setUsername(username);
	    account.setPassword(password);
	    System.out.println("responsebodybind2:" + account);
        return account;
    }
	
	@RequestMapping(value="/complex", method = {RequestMethod.GET})
    @ResponseBody
    public String complex(){
	    Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	    map.put("one", Arrays.asList(1));
	    map.put("two", Arrays.asList(1,2));
	    map.put("three", Arrays.asList(1,2,3));
	    map.put("four", Arrays.asList(1,2,3,4));
	    map.put("five", Arrays.asList(1,2,3,4,5));
	    //TODO
	    String result = JSON.toJSONString(map);
        return result;
    }
	
	@RequestMapping(value="/complex2", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,List<Integer>> complex2(){
	    Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	    map.put("one", Arrays.asList(1));
	    map.put("two", Arrays.asList(1,2));
	    map.put("three", Arrays.asList(1,2,3));
	    map.put("four", Arrays.asList(1,2,3,4));
	    map.put("five", Arrays.asList(1,2,3,4,5));
	    //TODO
        return map;
    }
	
}