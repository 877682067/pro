package com.jnl.boot.web.test.mapper;

import java.util.List;


import com.jnl.boot.web.page.PageParam;
import com.jnl.boot.web.test.entity.Test;

public interface TestMapper {
	public List<Test> list(PageParam<Test> param);
}
