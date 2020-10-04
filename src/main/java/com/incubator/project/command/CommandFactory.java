package com.incubator.project.command;

import com.incubator.project.command.general.GettingAccountsSumCommand;
import com.incubator.project.command.general.GettingRichestUserCommand;
import com.incubator.project.dao.DaoHelperFactory;
import com.incubator.project.service.AccountService;
import com.incubator.project.service.UserService;

public class CommandFactory {
    public static Command create(String command) {
        switch (command) {
            case "get_richest_user":
                return new GettingRichestUserCommand(new UserService(new DaoHelperFactory()), new AccountService(new DaoHelperFactory()));
            case "get_accounts_sum":
                return new GettingAccountsSumCommand(new AccountService(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("unknown command");
        }
    }
}
