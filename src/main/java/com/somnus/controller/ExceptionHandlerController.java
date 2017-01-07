package com.somnus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "exception")
public class ExceptionHandlerController {
	
	@ExceptionHandler({ ArithmeticException.class })
	@ResponseBody
	public String testArithmeticException(Exception e) {
		e.printStackTrace();
		return "testArithmeticException";
	}

	@ExceptionHandler({ RuntimeException.class })
	@ResponseBody
	public String testRuntimeException(Exception e) {
		e.printStackTrace();
		return "testRuntimeException";
	}

	/**
	 * 当一个controller中有多个HandleException注解出现时，那么异常被哪个方法捕捉呢？这就存在一个优先级的问题
	 * 因此我们可以确定，ExceptionHandler的优先级是：在异常的体系结构中，哪个异常与目标方法抛出的异常血缘关系越紧密，就会被哪个捕捉到
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "e/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String testExceptionHandle(@PathVariable(value = "id") Integer id) {
		System.out.println(10 / id);
		return id.toString();
	}
	
	@RequestMapping(value = "e2/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String testExceptionHandle2(@PathVariable(value = "id") Integer id) {
		List<String> list = Arrays.asList(new String[]{"a","b","c","d"});
		return list.get(id-1);
	}
}
