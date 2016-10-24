package com.somnus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.somnus.interceptor.AuthPassport;

@Controller
@RequestMapping(value = "databind")
public class ParamBindController {

	@AuthPassport
	@RequestMapping(value="parambind", method = {RequestMethod.GET})
    public ModelAndView paramBind(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("parambind");
        return modelAndView;
    }
	
	@AuthPassport
	@RequestMapping(value="parambind", method = {RequestMethod.POST})
    public ModelAndView paramBind(HttpServletRequest request, 
    		@RequestParam("urlParam") String urlParam, 
            @RequestParam("formParam") String formParam, 
            @RequestParam("formFile") MultipartFile formFile){
		
		//如果不用注解自动绑定，我们还可以像下面一样手动获取数据
		String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
		String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
        MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile"); 
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("urlParam", urlParam);
		modelAndView.addObject("formParam", formParam);
		modelAndView.addObject("formFileName", formFile.getOriginalFilename());
		
		modelAndView.addObject("urlParam1", urlParam1);
		modelAndView.addObject("formParam1", formParam1);
		modelAndView.addObject("formFileName1", formFile1.getOriginalFilename());
		
		modelAndView.setViewName("parambindresult");  
        return modelAndView;
    }
	
}