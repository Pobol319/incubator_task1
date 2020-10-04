package com.incubator.project.service;

import com.incubator.project.dao.DaoHelper;
import com.incubator.project.dao.DaoHelperFactory;
import com.incubator.project.dao.api.AccountDao;
import com.incubator.project.entity.Account;
import com.incubator.project.exceptions.DaoException;
import com.incubator.project.exceptions.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceUnitTest {
    @InjectMocks
    private AccountService service;
    private List<Account> accountList = new ArrayList<>();
    private Account account1;
    private Account account2;
    private Account account3;

    @Mock
    private DaoHelperFactory daoHelperFactory;
    @Mock
    private DaoHelper daoHelper;
    @Mock
    private AccountDao accountDao;

    @Before
    public void stetUp() throws DaoException {
        account1 = new Account(1, 100, 1);
        account2 = new Account(2, 1000, 2);
        account3 = new Account(3, 10000, 3);

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        when(daoHelperFactory.create()).thenReturn(daoHelper);
        when(daoHelper.createAccountDao()).thenReturn(accountDao);
        when(accountDao.getAll()).thenReturn(accountList);
    }

    @Test
    public void testGetAllAccounts() throws ServiceException {
        List<Account> accounts = service.getAllAccounts();
        Assert.assertEquals(3, accounts.size());
    }

    @Test(expected = ServiceException.class)
    public void testGetAllAccountsServiceException() throws ServiceException, DaoException {
        when(accountDao.getAll()).thenThrow(new DaoException());
        service.getAllAccounts();
    }

    @Test
    public void testGetSumOfAccounts() throws ServiceException {
        int actuallySum = service.getSumOfAccounts();
        int expectedSum = 11100;

        Assert.assertEquals(expectedSum, actuallySum);
    }

    @Test
    public void testGetRichestAccount() throws ServiceException {
        Account actualAccount = service.getRichestAccount();
        Assert.assertEquals(account3, actualAccount);
    }
}
