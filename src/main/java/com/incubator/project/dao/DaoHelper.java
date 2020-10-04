package com.incubator.project.dao;

import com.incubator.project.connection.ProxyConnectionFactory;
import com.incubator.project.connection.ProxyConnection;
import com.incubator.project.dao.api.AccountDao;
import com.incubator.project.dao.api.UserDao;
import com.incubator.project.dao.impl.AccountDaoImpl;
import com.incubator.project.dao.impl.UserDaoImpl;

public class DaoHelper {
    private ProxyConnection connection;

    public DaoHelper(ProxyConnectionFactory pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public AccountDao createAccountDao() {
        return new AccountDaoImpl(connection);
    }

}
