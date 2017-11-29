package com.jnl.pro.web.test.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jnl.pro.web.test.entity.Test;
import com.jnl.pro.web.test.service.TestService;
@Controller
@RequestMapping(value="test")
public class TestController {
	@Autowired
	private TestService testService;
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list()
	{
		List<Test> ls = testService.list(null);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data", ls);
		return new ModelAndView("", model);
	}
}
