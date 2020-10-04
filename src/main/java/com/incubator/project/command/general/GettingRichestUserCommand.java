package com.incubator.project.command.general;

import com.incubator.project.command.Command;
import com.incubator.project.command.CommandResult;
import com.incubator.project.entity.Account;
import com.incubator.project.entity.User;
import com.incubator.project.exceptions.ServiceException;
import com.incubator.project.service.AccountService;
import com.incubator.project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GettingRichestUserCommand implements Command {
    private static final String PAGE = "/index.jsp";
    private UserService userService;
    private AccountService accountService;

    public GettingRichestUserCommand(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Account richestAccount = accountService.getRichestAccount();
        User user = userService.getUserById(richestAccount.getUser_id()).get();
        String userFullName = user.getSureName() + " " + user.getName();
        request.setAttribute("richestUser", userFullName);
        return CommandResult.forward(PAGE);
    }
}
