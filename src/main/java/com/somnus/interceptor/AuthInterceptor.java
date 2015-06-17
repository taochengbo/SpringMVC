package com.somnus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
                //没有声明需要权限,或者声明不验证权限
            if(authPassport == null || authPassport.validate() == false){
                return true;
            } else{                
                //返回到登录界面
                response.sendRedirect("../account/login");
                return false;       
            }
        } else
            return true;   
     }
}