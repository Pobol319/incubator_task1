package com.incubator.project.mapper;

import com.incubator.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(User.ID_COLUMN);
        String name = resultSet.getString(User.NAME_COLUMN);
        String sureName = resultSet.getString(User.SURE_NAME_COLUMN);
        return new User(id, name, sureName);
    }
}
