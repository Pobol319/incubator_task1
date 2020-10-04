package com.incubator.project.dao.api;

import com.incubator.project.entity.User;
import com.incubator.project.exceptions.DaoException;

import java.util.Optional;

public interface UserDao {
    Optional<User> getById(Integer id) throws DaoException;
}
