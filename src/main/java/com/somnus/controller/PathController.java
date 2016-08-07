package com.somnus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/path")
public class PathController {

	/**
	 * URL通配符映射 ？”和“*”两个字符。其中“？”表示1个字符，“*”表示匹配多个字符，“**”表示匹配0个或多个路径
	 * 
	 * @return
	 */
	@RequestMapping(value = "/*", method = { RequestMethod.GET })
	public ModelAndView urlTest() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("path");
		modelAndView.addObject("msg", "任意没有匹配的访问url都会到我这里来");
		return modelAndView;
	}

	/**
	 * 对一个action配置多个URL映射
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/hello", "/world" })
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("path");
		modelAndView.addObject("msg", "访问路劲/path/hello，/path/world都会到我这里来");
		return modelAndView;
	}

	/**
	 * URL请求参数映射
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public ModelAndView getDetail(@PathVariable(value = "id") Integer id) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("path");
		modelAndView.addObject("msg", "@PathVariable注解拿到的请求参数映射ID为：" + id);
		return modelAndView;
	}

	/**
	 * URL正则表达式映射
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/reg/{name:\\w+}-{age:\\d+}", method = { RequestMethod.GET })
	public ModelAndView regUrlTest(@PathVariable(value = "name") String name,
			@PathVariable(value = "age") Integer age) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("path");
		modelAndView.addObject("msg", "URL正则表达式映射过来的name为：" + name + "，age为：" + age);
		return modelAndView;
	}

}
