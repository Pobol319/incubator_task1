package com.incubator.project.mapper;

import com.incubator.project.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(Account.ID_COLUMN);
        int account = resultSet.getInt(Account.ACCOUNT_COLUMN);
        Integer userId = resultSet.getInt(Account.USER_ID_COLUMN);
        return new Account(id, account, userId);
    }
}
