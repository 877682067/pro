package com.jnl.pro.web.test.service;

import java.util.List;

import com.jnl.pro.web.page.PageParam;
import com.jnl.pro.web.test.entity.Test;

public interface TestService {

	public List list(PageParam<Test> param);
	
	
}
