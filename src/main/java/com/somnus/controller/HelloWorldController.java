package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {
	
    /**
     * URL通配符映射
     * ？”和“*”两个字符。其中“？”表示1个字符，“*”表示匹配多个字符，“**”表示匹配0个或多个路径
     * @return
     */
	@RequestMapping(value="/*", method = {RequestMethod.GET})
    public ModelAndView urlTest(){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.setViewName("urltest");  
        return modelAndView;
    }
	
	/**
	 * 对一个action配置多个URL映射
	 * @return
	 */
	@RequestMapping(value={"/index","/hello"})
    public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("message", "Hello World!");  
		modelAndView.setViewName("index");  
        return modelAndView;
    }
	
	/**
	 * URL请求参数映射
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
    public ModelAndView getDetail(@PathVariable(value="id") Integer id){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("id", id);  
		modelAndView.setViewName("detail");  
        return modelAndView;
    }
	
	/**
	 * URL正则表达式映射
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/reg/{name:\\w+}-{age:\\d+}", method = {RequestMethod.GET})
    public ModelAndView regUrlTest(@PathVariable(value="name") String name, @PathVariable(value="age") Integer age){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.addObject("name", name); 
		modelAndView.addObject("age", age); 
		modelAndView.setViewName("regurltest");  
        return modelAndView;
    }
	
	/**
	 * 指定映射请求中或者某参数必须不等于某个值
	 * @return
	 */
	@RequestMapping(value="/paramstest", params="example!=AAA", method = {RequestMethod.GET})
	public ModelAndView paramsTest(){
		
		ModelAndView modelAndView = new ModelAndView();   
		modelAndView.setViewName("paramstest");  
        return modelAndView;
	}
	
}
