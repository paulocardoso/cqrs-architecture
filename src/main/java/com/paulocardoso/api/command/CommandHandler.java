package com.paulocardoso.api.command;

public interface CommandHandler<C, R> {

    R handle(C command);
}
