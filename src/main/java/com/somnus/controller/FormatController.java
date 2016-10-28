package com.somnus.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "format")
public class FormatController {
	
	@RequestMapping(value="test", method = {RequestMethod.GET})
	public String test(Model model) throws NoSuchFieldException, SecurityException{
		if(!model.containsAttribute("contentModel")){
            
			Format format=new Format();

			format.setMoney(12345.678);
			format.setDate(new Date());
            
            model.addAttribute("contentModel", format);
        }
		return "formattest";
	}
	
	public static class Format{
		
		@NumberFormat(style=Style.CURRENCY)
		private double money;
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date date;
		
		public double getMoney(){
			return money;
		}
		public Date getDate(){
			return date;
		}
		
		public void setMoney(double money){
			this.money=money;
		}
		public void setDate(Date date){
			this.date=date;
		}
			
	}
	
}
