package com.jnl.boot.web.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnl.boot.web.test.mapper.TestMapper;
@Controller
public class TestController {
	 private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestMapper  testmapper;
	
	@RequestMapping("/")
	public String list() {
		List ls=testmapper.list(null);
		logger.info(ls.size()+"");
		return  null;
	}
}
