package com.somnus.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

public abstract class WebUtils {
	
	public static HttpServletRequest getRequest() {
		return ServletRequestAttributes.class.cast(RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
    	return ServletWebRequest.class.cast(RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
