package com.paulocardoso.user;

import com.paulocardoso.api.command.CommandBusImpl;
import com.paulocardoso.api.event.EventBus;
import com.paulocardoso.api.event.EventBusImpl;
import org.junit.Test;

public class CreateUserTest {

    @Test
    public void itShouldCreateUser(){

        EventBus eventBus = new EventBusImpl();
        eventBus.register(new UserCreatedEventHandler());

        var bus = new CommandBusImpl();
        var writeUserRepository = new WriteUserRepository();

        bus.register(new CreateUserCommandHandler(eventBus, writeUserRepository));

        var createUserCommand = new CreateUserCommand("john2");
        bus.execute(createUserCommand);

    }
}
