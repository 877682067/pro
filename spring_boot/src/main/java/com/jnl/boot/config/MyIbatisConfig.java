package com.jnl.boot.config;

import javax.sql.DataSource;

import com.jnl.boot.web.handler.DataTypeHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jnl.boot.web.page.PagingPlugin;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class MyIbatisConfig {
	private static Logger  log = LoggerFactory.getLogger(PagingPlugin.class);
	@Autowired
	private DataSource dataSource;
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		log.error("-------------ibatis init");
		System.out.println("---------------------");
		System.out.println("---------------------");
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
       // bean.setTypeAliasesPackage("com.jnl.boot.web.*");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath*:com/jnl/boot/web/*/mapper/*.xml"));
        PagingPlugin plugin = new PagingPlugin();
		bean.setPlugins(new Interceptor[]{plugin});
		TypeHandler[] handlers = new TypeHandler[1];
		handlers[0] = new DataTypeHandler();
		bean.setTypeHandlers(handlers);
        try {
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
