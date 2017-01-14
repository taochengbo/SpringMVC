package com.somnus.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

public abstract class WebUtil {
	
	public static HttpServletRequest getRequest() {
		return ServletRequestAttributes.class.cast(RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
    	return ServletWebRequest.class.cast(RequestContextHolder.getRequestAttributes()).getResponse();
    }
    
    /**
     * 获取项目访问根路径
     * @param request
     * @return
     */
    public static String getRootPath(HttpServletRequest request){
    	String path = request.getContextPath();
    	return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }
    
    /**
     * 获取项目访问根路径
     * @return
     */
    public static String getRootPath(){
    	HttpServletRequest request = getRequest();
    	String path = request.getContextPath();
    	return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    }
    
}
