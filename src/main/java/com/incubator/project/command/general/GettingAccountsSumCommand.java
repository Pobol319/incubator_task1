package com.incubator.project.command.general;

import com.incubator.project.command.Command;
import com.incubator.project.command.CommandResult;
import com.incubator.project.exceptions.ServiceException;
import com.incubator.project.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GettingAccountsSumCommand implements Command {
    private static final String PAGE = "index.jsp";
    private AccountService service;

    public GettingAccountsSumCommand(AccountService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int sumOfAccounts;
        sumOfAccounts = service.getSumOfAccounts();
        request.setAttribute("sumOfAccounts", sumOfAccounts);
        return CommandResult.forward(PAGE);
    }
}
