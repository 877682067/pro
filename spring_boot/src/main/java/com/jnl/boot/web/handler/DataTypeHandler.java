package com.jnl.boot.web.handler;

import com.jnl.boot.utils.convert.ConvertUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class DataTypeHandler implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        String data = resultSet.getString(s);
        //mysql 数据类型转换为java作为输出
        return  ConvertUtils.convertDataType(data);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        String data = resultSet.getString(i);
        return  ConvertUtils.convertDataType(data);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        String data = callableStatement.getString(i);
        return  ConvertUtils.convertDataType(data);
    }
}
