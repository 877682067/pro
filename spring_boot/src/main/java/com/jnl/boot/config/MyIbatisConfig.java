package com.jnl.boot.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jnl.boot.web.page.PagingPlugin;

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
		System.out.println("---------------------");
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.jnl.boot.web.*");
    /*    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));*/
        PagingPlugin plugin = new PagingPlugin();
		bean.setPlugins(new Interceptor[]{plugin});
        try {
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
