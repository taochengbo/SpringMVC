package com.somnus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_GATEWAY)
public class HttpStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpStatusException() {
		super();		
	}

	public HttpStatusException(String message, Throwable cause) {
		super(message, cause);		
	}

	public HttpStatusException(String message) {
		super(message);		
	}

	public HttpStatusException(Throwable cause) {
		super(cause);
	}
	
}
