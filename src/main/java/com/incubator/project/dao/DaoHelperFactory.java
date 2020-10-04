package com.incubator.project.dao;

import com.incubator.project.connection.ProxyConnectionFactory;

public class DaoHelperFactory {
    public DaoHelper create() {
        return new DaoHelper(ProxyConnectionFactory.getInstance());
    }
}
