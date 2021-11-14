package com.paulocardoso.api.command;

public interface CommandBus {

    <C> void execute(C command);

    <C extends Command<R>, R> R execute(C command);

    <C extends Command<R>, R> void register(CommandHandler handler);
}
