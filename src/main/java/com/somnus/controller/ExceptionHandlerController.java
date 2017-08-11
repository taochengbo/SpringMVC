package com.somnus.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "exception")
public class ExceptionHandlerController {
	
	/**
	 * 这个只会是在当前的Controller里面起作用，如果想在所有的Controller里面统一处理异常的话，
	 * 可以用@ControllerAdvice来创建一个专门处理的类。
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ ArithmeticException.class })
	@ResponseBody
	public List<Integer> handleArithmeticException(Exception e) {
		e.printStackTrace();
		return Arrays.asList(new Integer[]{1,2,3,4});
	}
	
	@ExceptionHandler({ NullPointerException.class })
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public void handleNullPointerException(Exception e) {
		e.printStackTrace();
	}

	/*@ExceptionHandler({ RuntimeException.class })
	@ResponseBody
	public String handleRuntimeException(Exception e) {
		e.printStackTrace();
		return "testRuntimeException";
	}*/

	/**
	 * 当一个controller中有多个HandleException注解出现时，那么异常被哪个方法捕捉呢？这就存在一个优先级的问题
	 * 因此我们可以确定，ExceptionHandler的优先级是：在异常的体系结构中，哪个异常与目标方法抛出的异常血缘关系越紧密，就会被哪个捕捉到
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "e/{id}", method = { RequestMethod.GET }, headers="Accept=application/json")
	@ResponseBody
	public List<String> testExceptionHandle(@PathVariable(value = "id") Integer id) {
		System.out.println(10 / id);
		
		return Arrays.asList(new String[]{"a","b","c","d"});
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "e2/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String testExceptionHandle2(@PathVariable(value = "id") Integer id) {
		List<String> list = Arrays.asList(new String[]{"a","b","c","d"});
		return list.get(id-1);
	}
	
	@RequestMapping(value = "e3/{id}", method = { RequestMethod.GET })
	@ResponseBody
	public String testExceptionHandle3(@PathVariable(value = "id") Integer id) {
		List<String> list = 4 % id == 0 ? null : Arrays.asList(new String[]{"a","b","c","d"});
		return list.get(id);
	}
}
