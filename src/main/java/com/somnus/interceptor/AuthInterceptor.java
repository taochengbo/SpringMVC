package com.somnus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
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
    
	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在 
	 * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
	 * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返回值为false，
	 * 当preHandle的返回值为false的时候整个请求就结束了。
	 */
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
    
    /**
     * 该方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，
     * 它的执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行，
     * 但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操作.
     */
    @Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	// TODO Auto-generated method stub
	}
    
    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override  
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
    }
}