package com.somnus.advice;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 对使用HttpMessageConverter的@ResponseBody的支持 
 */
@Order(2)  
/* 需要被扫描 */
@ControllerAdvice(basePackages = "com.somnus")//配置你需要路径下的控制器
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback", "jsonp"); //指定jsonpParameterNames
    }
}
