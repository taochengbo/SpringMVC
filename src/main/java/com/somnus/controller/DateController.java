package com.somnus.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "date")
public class DateController {
	
	@RequestMapping(value="test", method = {RequestMethod.GET})
	@ResponseBody
    public Account test(Account account){
		System.out.println(JSON.toJSON(account));
        return account;
    }
	
	public static class Account {
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date tranDate;

		public Date getTranDate() {
			return tranDate;
		}

		public void setTranDate(Date tranDate) {
			this.tranDate = tranDate;
		}

	}
}
