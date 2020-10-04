package com.incubator.project.dao.api;

import com.incubator.project.entity.Account;
import com.incubator.project.exceptions.DaoException;

import java.util.List;

public interface AccountDao {
    List<Account> getAll() throws DaoException;
}
