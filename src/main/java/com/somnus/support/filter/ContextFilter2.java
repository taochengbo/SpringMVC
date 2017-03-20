package com.somnus.support.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.somnus.support.holder.ApplicationContextHolder;

@WebFilter(filterName = "ContextFilter2",urlPatterns = "/*")
public class ContextFilter2 extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("第二种方式获取Spring中的bean:" + ApplicationContextHolder.getBean("baseService"));
		filterChain.doFilter(request, response);
	}
}
