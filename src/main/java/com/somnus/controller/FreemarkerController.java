package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "freemarker")
public class FreemarkerController {
    
    @RequestMapping(value="freemarker", method = {RequestMethod.GET})
    public String freemarker(Model model){
    	model.addAttribute("blogTitle", "Freemarker Template Demo using Spring");
    	model.addAttribute("message", "Getting started with Freemarker.<br/>Find a Freemarker template demo using Spring.");
        return "freemarker";
    }
    
}
