package com.ddos.pizza.typehander;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class IdTypeHander extends BaseTypeHandler<UUID> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid,JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, uuid.toString());
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return UUID.fromString(resultSet.getString(s));
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return UUID.fromString(resultSet.getString(i));
    }

    @Override
    public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return UUID.fromString(callableStatement.getString(i));
    }
}
