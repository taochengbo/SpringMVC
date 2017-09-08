package com.somnus.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.somnus.util.WebUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

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
	    mv.setViewName("viewResolver");
        return mv;
    }
    @RequestMapping(value="viewResolver2", method = {RequestMethod.GET})
    public String viewResolver2(Model model){
	    Account account = new Account();
	    account.setUsername(WebUtil.getRequest().getParameter("username"));
	    account.setPassword(WebUtil.getRequest().getParameter("password"));
	    model.addAttribute(account);
        return "viewResolver";
    }
    

    @RequestMapping(value="download",method = RequestMethod.GET)
    public String getDocuments(Model model) {
    	List<Course> documents = Arrays.asList(
                new Course(1, "Spring MVC Xls View", new Date()),
                new Course(2, "Spring MVC Xlsx View", new Date()),
                new Course(3, "Spring MVC XlsxStreaming View", new Date())
        );
        model.addAttribute("courses", documents);
        return "index";
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
    
    @XStreamAlias("account")
    public static class Account{
		
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
    
    public static class Course {

        private Integer id;
        private String name;
        private Date date;

        public Course() {
        }

        public Course(Integer id, String name, Date date) {
            this.id = id;
            this.name = name;
            this.date = date;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }
    }
}
