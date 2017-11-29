package com.jnl.pro.web.page;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

@Intercepts({
	@Signature(type= StatementHandler.class,method ="prepare",args={Connection.class,Integer.class})
})
public class PagingPlugin implements Interceptor {
	private String dbType;
	private Integer defaultPage;
	private Integer defaultPageSize;
	
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler handler = getUnProxyObject(invocation);
		MetaObject metaHandler = SystemMetaObject.forObject(handler);
		String  sql = metaHandler.getValue("delegate.boundSql.sql").toString();
		if(!checkSelect(sql)){
			invocation.proceed();
		}
		BoundSql boundSql = (BoundSql) metaHandler.getValue("delegate.boundSql");
		PageParam pageParam = getPageParam(boundSql);
		if(pageParam ==null)
		{
			pageParam = new PageParam();
		}
		defaultPage = pageParam.getPage()==null?1:pageParam.getPage();
		defaultPageSize = pageParam.getPageSize()==null?1:pageParam.getPageSize();
		int total = getTotal(invocation,metaHandler,boundSql);
		setTotalToPageParams(pageParam,total);
		return changeSql(invocation,metaHandler,boundSql,pageParam);
	}


	private Object changeSql(Invocation invocation, MetaObject metaHandler, BoundSql boundSql, PageParam pageParam) throws Exception {

		String sql  = metaHandler.getValue("delegate.boundSql.sql").toString();
		String  newSql = "select *  from ("+sql+") data limit ?,?";
		metaHandler.setValue("delegate.boundSql.sql", newSql);
		PreparedStatement ps = (PreparedStatement) invocation.proceed();
		int parameterCount = ps.getParameterMetaData().getParameterCount();
		int pageNum = pageParam.getPage()*pageParam.getPageSize();
		ps.setInt(parameterCount-1, pageNum);
		ps.setInt(parameterCount, pageNum+pageParam.getPageSize());
		return ps;
	}

	private void setTotalToPageParams(PageParam pageParam, int total) {
		pageParam.setTotal(total);
		int totalPage = total%this.defaultPageSize==0?total/this.defaultPageSize:total/this.defaultPageSize+1;
		pageParam.setTotalPage(totalPage);
	}
	//查询获取总数
	private int getTotal(Invocation invocation,MetaObject metaHandler, BoundSql boundSql) {
		MappedStatement mappStat =  (MappedStatement) metaHandler.getValue("delegate.mappedStatement");
		Configuration cfg = mappStat.getConfiguration();
		String  sql = metaHandler.getValue("delegate.boundSql.sql").toString();
		String  countSql = "select count(*) as total from ("+sql+") data";
		Connection connect = (Connection) invocation.getArgs()[0];
		PreparedStatement ps = null;
		int total = 0;
		try {
			ps = connect.prepareStatement(countSql);
			BoundSql countBoundSql = new BoundSql(cfg, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
			ParameterHandler parameterHandler = new DefaultParameterHandler(mappStat, boundSql.getParameterObject(), countBoundSql);
			parameterHandler.setParameters(ps);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()){
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return total;
	}
	//获取分页信息
	private PageParam getPageParam(BoundSql boundSql) {
		Object paramObject = boundSql.getParameterObject();
		if(paramObject == null)
			return null;
		PageParam param = null;
		if(paramObject instanceof Map){
			Map paramMap = (Map) paramObject;
			@SuppressWarnings("unchecked")
			Iterator<Object> itor = paramMap.entrySet().iterator();
			while (itor.hasNext()){
				Object value = itor.next();
				if(value instanceof PageParam){
					param = (PageParam) value;
					break;
				}
			}
		}else if(paramObject instanceof PageParam){
			param = (PageParam) paramObject;
		}
		return param;
	}
	//检查是否是查询
	private boolean checkSelect(String sql) {
		sql = sql.trim();
		int index = sql.toLowerCase().indexOf("select");
		return index==0;
	}
	//获取原对象（非代理对象）
	private StatementHandler getUnProxyObject(Invocation invocation) {
		Object unProxyObject = null;
		StatementHandler handler = (StatementHandler) invocation.getTarget();
		MetaObject metaHandler = SystemMetaObject.forObject(handler);
		while(metaHandler.hasGetter("h")){
			unProxyObject = metaHandler.getValue("h");
		}
		if(unProxyObject == null){
			unProxyObject = handler;
		}
		return (StatementHandler) unProxyObject;
	}

	public Object plugin(Object statmentHander) {
		return Plugin.wrap(statmentHander, this);
	}

	public void setProperties(Properties props) {
		this.defaultPage = Integer.parseInt(props.getProperty("default.page","1"));
		this.defaultPageSize = Integer.parseInt(props.getProperty("default.pageSize","1"));
	}


	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

}
