package com.incubator.project.command;

public class CommandResult {
    private final String page;

    private CommandResult(String page) {
        this.page = page;
    }

    public static CommandResult forward(String page) {
        return new CommandResult(page);
    }
}
