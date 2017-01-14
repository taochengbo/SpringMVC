package com.somnus.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.somnus.util.WebUtil;

/** 
 * @Title: AccountController.java 
 * @Package com.somnus.controller 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月16日 下午3:54:32 
 * @version V1.0 
 */
@Controller
@RequestMapping(value = "account")
public class AccountController {
    
    @RequestMapping(value="json", method = {RequestMethod.GET})
    public void json(HttpServletResponse response, PrintWriter out){
    	/*response.setContentType("application/json;charset=UTF-8");*/
    	/*response.setContentType("application/xml;charset=UTF-8");*/
    	response.setContentType("text/html;charset=utf-8");
    	response.setHeader("pragma","no-cache");
    	response.setHeader("cache-control","no-cache");
    	out.write("{\"success\":"+true+",\"tip\":\"用户名已存在\"}");
    }
    
    /**
     * <p>.json结尾返回json</p>  
     * <p>.xml结尾返回xml</p>   
     * @author：Somnus
     * @return
     */
    @RequestMapping(value="viewResolver", method = {RequestMethod.GET})
    public ModelAndView viewResolver(){
    	ModelAndView mv = new ModelAndView();
	    Account account = new Account();
	    account.setUsername(WebUtil.getRequest().getParameter("username"));
	    account.setPassword(WebUtil.getRequest().getParameter("password"));
	    mv.addObject(account);
        return mv;
    }
    
    @RequestMapping(value="map", method = {RequestMethod.GET})
    public ModelAndView map(HttpServletRequest request){
    	Map<String, Object> param = WebUtils.getParametersStartingWith(request, "");
    	System.out.println(param);
    	/* ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※*/
    	ModelAndView mv = new ModelAndView();
	    mv.addAllObjects(param);
        return mv;
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
