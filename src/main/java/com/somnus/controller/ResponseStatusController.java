package com.somnus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.somnus.exception.HttpStatusException;

@Controller
@RequestMapping(value = "status")
public class ResponseStatusController {
	
	@RequestMapping(value = "e/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String status(@PathVariable(value = "id") Integer id){
		if(id % 2 != 0){
			throw new HttpStatusException();
		}
		return id.toString();
	}
	
	/**
	 * ResponseStatus修饰目标方法，无论它执行方法过程中有没有异常产生，用户都会得到异常的界面。而目标方法正常执行
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "e2/{id}", method = { RequestMethod.GET })
	@ResponseStatus(value=HttpStatus.BAD_GATEWAY)
	@ResponseBody
	public String status2(@PathVariable(value = "id") Integer id){
		if(id % 2 != 0){
			throw new HttpStatusException();
		}
		return id.toString();
	}

}
