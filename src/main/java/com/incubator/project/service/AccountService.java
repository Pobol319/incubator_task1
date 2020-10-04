package com.incubator.project.service;

import com.incubator.project.dao.DaoHelper;
import com.incubator.project.dao.DaoHelperFactory;
import com.incubator.project.dao.api.AccountDao;
import com.incubator.project.entity.Account;
import com.incubator.project.exceptions.DaoException;
import com.incubator.project.exceptions.ServiceException;

import java.util.List;

public class AccountService {
    private DaoHelperFactory daoHelperFactory;

    public AccountService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Account> getAllAccounts() throws ServiceException {
        try {
            DaoHelper factory = daoHelperFactory.create();
            AccountDao accountDao = factory.createAccountDao();
            return accountDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public int getSumOfAccounts() throws ServiceException {
        List<Account> accounts = getAllAccounts();
        int sumOfAccounts = 0;
        for (Account account : accounts) {
            sumOfAccounts = sumOfAccounts + account.getAccount();
        }
        return sumOfAccounts;
    }

    public Account getRichestAccount() throws ServiceException {
        List<Account> accounts = getAllAccounts();
        int maxAccountSum = 0;
        Account richestAccount = null;
        for (Account account : accounts) {
            if (account.getAccount() > maxAccountSum) {
                maxAccountSum = account.getAccount();
                richestAccount = account;
            }
        }
        return richestAccount;
    }
}
