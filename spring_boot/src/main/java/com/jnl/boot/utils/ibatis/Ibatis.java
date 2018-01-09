package com.jnl.boot.utils.ibatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.jnl.boot.utils.ApplactionContextUtil;
import com.jnl.boot.web.build.vo.DataBaseConnector;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

public class Ibatis  {
    private volatile static Ibatis singleton;
    private ApplicationContext context;
    private Ibatis (){
        this.context = ApplactionContextUtil.getApplicationContext();
    }
    private static AtomicReference<DataBaseConnector>  oriConnet;
    public void  changeDataBase(DataBaseConnector connetInfo){
        Object obj =  this.context.getBean("sqlSessionFactoryBean");
        SqlSessionFactory foctory = (SqlSessionFactory)obj;
        Configuration configuration = foctory.getConfiguration();
        Environment environment = configuration.getEnvironment();
        DruidDataSource dataSource = (DruidDataSource)environment.getDataSource();
        if(oriConnet==null){
            DataBaseConnector ori = new DataBaseConnector();
            ori.setUser(dataSource.getUsername());
            ori.setPassword(dataSource.getPassword());
            ori.setUrl(dataSource.getUrl());
            oriConnet.set(ori);
        }
        dataSource.setUsername(connetInfo.getUser());
        dataSource.setPassword(connetInfo.getPassword());
        dataSource.setUrl(connetInfo.getUrl());
        dataSource.setDbType("mysql");
        try {
            dataSource.restart();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void reduction(){
        this.changeDataBase(oriConnet.get());
    }

    public static Ibatis getInstance(){
        if(singleton==null){
            synchronized (Ibatis.class) {
                if(singleton == null){
                    return new Ibatis();
                }
            }
        }
        return singleton;
    }
}
