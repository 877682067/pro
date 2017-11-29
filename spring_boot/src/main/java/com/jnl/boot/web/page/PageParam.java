package com.jnl.boot.web.page;

import java.util.List;

public class PageParam<T> {
	
	private Integer totalPage;//总页数
	
	private Integer total;//总数
	
	private Integer pageSize;//每页数量

	private Integer page;//当前页
	
	private List<T> data;
	
	private T param;
	
	private String order;//排序

	public PageParam()
	{
		pageSize = 10;
		page = 1;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}