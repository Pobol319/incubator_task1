package com.incubator.project.dao.impl;

import com.incubator.project.dao.AbstractDao;
import com.incubator.project.dao.api.AccountDao;
import com.incubator.project.entity.Account;

import java.sql.Connection;

public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao {
    private static final String TABLE = "accounts";

    public AccountDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

}
