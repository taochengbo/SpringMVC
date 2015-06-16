package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * @Title: AccountController.java 
 * @Package com.somnus.controller 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月16日 下午3:54:32 
 * @version V1.0 
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    
    @RequestMapping(value="/login", method = {RequestMethod.GET})
    public String login(){
        
        return "login";
    }
}
