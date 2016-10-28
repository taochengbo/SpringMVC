package com.somnus.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "bigdecimal")
public class BigdecimalController {
	
	@RequestMapping(value="test", method = {RequestMethod.GET})
	@ResponseBody
    public Account test(Account account){
		System.out.println(JSON.toJSON(account));
        return account;
    }
	
	public static class Account {
		private BigDecimal tranAmt;

		public BigDecimal getTranAmt() {
			return tranAmt;
		}

		public void setTranAmt(BigDecimal tranAmt) {
			this.tranAmt = tranAmt;
		}
	}
}
