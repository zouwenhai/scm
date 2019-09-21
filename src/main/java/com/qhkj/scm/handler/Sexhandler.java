package com.qhkj.scm.handler;

import com.qhkj.scm.model.Man;
import com.qhkj.scm.model.Sex;
import com.qhkj.scm.model.WoMan;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Sexhandler
 * @Description 性别hangdler
 * @Author zouwenhai
 * @Date 2019/9/1 23:31
 * @Version 1.0
 */
@MappedJdbcTypes(JdbcType.INTEGER)
public class Sexhandler extends BaseTypeHandler<Sex> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {

        if (sex instanceof Man) {
            preparedStatement.setInt(i, 0);
        }
        if (sex instanceof WoMan) {
            preparedStatement.setInt(i, 1);
        }


    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, String s) throws SQLException {

        if (resultSet.getInt(s) == 0) {
            return new WoMan();
        }
        if (resultSet.getInt(s) == 1) {
            return new Man();
        }
        return null;


    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, int i) throws SQLException {

        if (resultSet.getInt(i) == 0) {
            return new WoMan();
        }
        if (resultSet.getInt(i) == 1) {
            return new Man();
        }
        return null;


    }

    @Override
    public Sex getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        if (callableStatement.getInt(i) == 0) {
            return new WoMan();
        }
        if (callableStatement.getInt(i) == 1) {
            return new Man();
        }

        return null;
    }
}

