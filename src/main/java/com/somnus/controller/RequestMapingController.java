package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "request")
public class RequestMapingController {

	/**
	 * Request headers
	 * 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
	 * @return
	 */
	@RequestMapping(value="consumes", consumes="application/json;charset=utf-8")
	@ResponseBody
    public String consumes(){
		return "consumes";
    }
	
	/**
	 * Response headers
	 * 指定处理响应的内容类型（Content-Type），例如application/json, text/html;
	 * @return
	 */
	@RequestMapping(value="produces", produces="application/json;charset=utf-8")
	@ResponseBody
    public String produces(){
		return "consumes";
    }
	@RequestMapping(value="produces2", produces="application/xml;charset=utf-8")
	@ResponseBody
    public String produces2(){
		return "produces2";
    }
	@RequestMapping(value="produces3", produces="text/html;charset=utf-8")
	@ResponseBody
    public String produces3(){
		return "produces3";
    }
	
	
	/**
	 * 如若设置Content-Type：text/html，基本等同于consumes
	 * Content-Type代表发送端（客户端|服务器）发送的实体数据的数据类型。 
	 * 
	 * @return
	 */
	@RequestMapping(value="header", headers="Content-Type=application/json;charset=utf-8")
	@ResponseBody
    public String header(){
		return "header";
    }
	@RequestMapping(value="header2", headers="Content-Type=application/xml;charset=utf-8")
	@ResponseBody
    public String header2(){
		return "header2";
    }
	@RequestMapping(value="header3", headers="Content-Type=text/html;charset=utf-8")
	@ResponseBody
    public String header3(){
		return "header3";
    }
	
	/**
	 * 如若设置Accept: text/html，基本等同于produces
	 * Accept代表发送端（客户端）希望接受的数据类型
	 * 
	 * @return
	 */
	@RequestMapping(value="headers", headers="Accept=application/json;charset=utf-8")
	@ResponseBody
    public String headers(){
		return "headers";
    }
	@RequestMapping(value="headers2", headers="Accept=application/xml;charset=utf-8")
	@ResponseBody
    public String headers2(){
		return "headers2";
    }
	@RequestMapping(value="headers3", headers="Accept=text/html;charset=utf-8")
	@ResponseBody
    public String headers3(){
		return "headers3";
    }
	
}
class Account{
	
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