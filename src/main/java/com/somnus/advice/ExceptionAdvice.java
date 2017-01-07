package com.somnus.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler({ ArrayIndexOutOfBoundsException.class })
	public String testArrayIndexOutOfBoundsException(Exception e) {
		e.printStackTrace();
		return "testArrayIndexOutOfBoundsException";
	}

}
