package com.somnus.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler({ ArrayIndexOutOfBoundsException.class })
	@ResponseBody
	public String handleArrayIndexOutOfBoundsException(Exception e) {
		e.printStackTrace();
		return "testArrayIndexOutOfBoundsException";
	}
	
	/**
	 * 为了防止@ResponseStatus标注的异常被Spring框架处理，可以这样编写全局异常处理类：
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public String handException(HttpServletRequest request ,Exception e) throws Exception {
		e.printStackTrace();
		//If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
			throw e;
		}
		// Otherwise setup and send the user to a default error-view.
		/*ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;*/
		return "testArrayIndexOutOfBoundsException";
	}

}
