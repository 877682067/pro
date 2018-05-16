package com.jnl.pro.web.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jnl.pro.web.page.PageParam;
import com.jnl.pro.web.test.entity.Test;

@Repository
public interface TestMapper {
	
	List<Test> list(PageParam<Test> param);
/*
	public List<Test> list(Test param);
	
	public Test findByID();
	
	public int inser(Test test);
	
	public int update(Test test);*/
}
