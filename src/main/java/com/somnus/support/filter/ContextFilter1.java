package com.somnus.support.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.support.RequestContextUtils;


@WebFilter(filterName = "ContextFilter1",urlPatterns = "/*")
public class ContextFilter1 extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		WebApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
		System.out.println("第一种方式获取Spring中的bean:" + ctx.getBean("baseService"));
		filterChain.doFilter(request, response);
	}
}
