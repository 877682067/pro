package com.jnl.pro.web.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnl.pro.web.page.PageParam;
import com.jnl.pro.web.test.entity.Test;
import com.jnl.pro.web.test.mapper.TestMapper;
import com.jnl.pro.web.test.service.TestService;

@Service(value="testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestMapper  testMapper;
	
	public List list(PageParam<Test> param) {
		return testMapper.list(param);
	}

}
