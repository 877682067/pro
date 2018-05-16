package com.jnl.boot.web.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Boolean.class)
@MappedJdbcTypes(JdbcType.CHAR)
public class BooleanHandler implements TypeHandler<Boolean>{
    private static Logger log = Logger.getLogger(BooleanHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        int data = aBoolean?1:0;
        preparedStatement.setInt(i,data);
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String s) throws SQLException {
        Integer tof = null;
        try{
            tof = resultSet.getInt(s);
        }catch (Exception e){
            log.error("请确认该字段存储的值是否未1|0");
            throw new SQLException("请确认该字段存储的值是否未1|0");
        }
        return tof == 1;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        Integer tof = null;
        try{
            tof = resultSet.getInt(i);
        }catch (Exception e){
            log.error("请确认该字段存储的值是否未1|0");
            throw new SQLException("请确认该字段存储的值是否未1|0");
        }
        return tof == 1;
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer tof = null;
        try{
            tof = callableStatement.getInt(i);
        }catch (Exception e){
            log.error("请确认该字段存储的值是否未1|0");
            throw new SQLException("请确认该字段存储的值是否未1|0");
        }
        return tof.intValue() == 1;
    }
}
