package com.incubator.project.mapper;

import com.incubator.project.entity.Account;
import com.incubator.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<?> create(String table) {
        switch (table) {
            case User.TABLE:
                return new UserRowMapper();
            case Account.TABLE:
                return new AccountRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table - " + table);
        }
    }
}
