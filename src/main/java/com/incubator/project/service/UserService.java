package com.incubator.project.service;

import com.incubator.project.dao.DaoHelper;
import com.incubator.project.dao.DaoHelperFactory;
import com.incubator.project.dao.api.UserDao;
import com.incubator.project.entity.User;
import com.incubator.project.exceptions.DaoException;
import com.incubator.project.exceptions.ServiceException;

import java.util.Optional;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> getUserById(Integer userId) throws ServiceException {
        try {
            DaoHelper factory = daoHelperFactory.create();
            UserDao userDao = factory.createUserDao();
            return userDao.getById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
