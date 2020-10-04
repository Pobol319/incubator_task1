package com.incubator.project.service;

import com.incubator.project.dao.DaoHelper;
import com.incubator.project.dao.DaoHelperFactory;
import com.incubator.project.dao.api.UserDao;
import com.incubator.project.entity.User;
import com.incubator.project.exceptions.DaoException;
import com.incubator.project.exceptions.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {
    @InjectMocks
    private UserService service;
    private User user;

    @Mock
    private DaoHelperFactory daoHelperFactory;
    @Mock
    private DaoHelper daoHelper;
    @Mock
    private UserDao userDao;

    @Before
    public void setUp() throws DaoException {
        user = new User(1, "Pavel", "Pobol");
        Optional<User> optionalUser = Optional.of(user);

        when(daoHelperFactory.create()).thenReturn(daoHelper);
        when(daoHelper.createUserDao()).thenReturn(userDao);
        when(userDao.getById(user.getId())).thenReturn(optionalUser);
    }

    @Test
    public void testGetUserById() throws ServiceException {
        Optional<User> expectedOptionalUser = service.getUserById(1);
        User expectedUser = expectedOptionalUser.get();

        Assert.assertEquals(expectedUser, user);
    }

    @Test(expected = ServiceException.class)
    public void testGetUserByIdServiceException() throws DaoException, ServiceException {
        when(userDao.getById(1)).thenThrow(new DaoException());
        service.getUserById(1);
    }
}
