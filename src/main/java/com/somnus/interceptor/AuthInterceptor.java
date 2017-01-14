package com.somnus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @Title: AuthInterceptor.java 
 * @Package com.somnus.interceptor 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月16日 下午3:59:23 
 * @version V1.0 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
            Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            /*AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);*/
            AuthPassport authPassport = AnnotationUtils.findAnnotation(((HandlerMethod) handler).getMethod(), AuthPassport.class);
            //没有声明需要权限,或者声明不验证权限
            if(authPassport == null || authPassport.validate() == false){
                return true;
            } else{
            	/* /SpringMVC */
            	System.out.println("request.getContextPath()-->"+request.getContextPath());
            	/* /databind/parambind */
            	System.out.println("request.getServletPath()-->"+request.getServletPath());
            	/* /SpringMVC/databind/parambind */
            	System.out.println("request.getRequestURI()-->"+request.getRequestURI());
            	/* E:\github\SpringMVC\src\main\webapp */
            	System.out.println(request.getSession().getServletContext().getRealPath("/"));
            	response.setContentType("text/html;charset=utf-8");
            	response.getWriter().write("你管我写啥");
                return false;
            }
        } else
            return true;
     }
}