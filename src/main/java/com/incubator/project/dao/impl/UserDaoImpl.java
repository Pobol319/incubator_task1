package com.incubator.project.dao.impl;

import com.incubator.project.dao.AbstractDao;
import com.incubator.project.dao.api.UserDao;
import com.incubator.project.entity.User;
import com.incubator.project.exceptions.DaoException;
import com.incubator.project.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String TABLE = "users";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM users WHERE user_id = ?";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public Optional<User> getById(Integer id) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_ID, new UserRowMapper(), id);
    }
}
