package com.paulocardoso.user;

import com.paulocardoso.api.command.CommandBusImpl;
import com.paulocardoso.api.event.EventBus;
import com.paulocardoso.api.event.EventBusImpl;
import org.junit.Test;

import java.util.Set;

public class CreateUserTest {

    @Test
    public void itShouldCreateUser(){

        EventBus eventBus = new EventBusImpl();
        eventBus.register(new UserCreatedEventHandler());

        var bus = new CommandBusImpl();
        bus.register(new CreateUserCommandHandler(eventBus));

        var createUserCommand = new CreateUserCommand("john2");
        bus.execute(createUserCommand);

    }
}
