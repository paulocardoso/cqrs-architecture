package com.paulocardoso.user;

import com.paulocardoso.api.event.Event;
import com.paulocardoso.api.event.Subscribable;

import java.util.Set;
import java.util.logging.Logger;

public class UserCreatedEventHandler implements Subscribable {

    public static Logger LOGGER = Logger.getLogger(UserCreatedEventHandler.class.getName());


    @Override
    public void handle(Event event) {
        UserCreated userCreated = (UserCreated) event;
        LOGGER.info("User Created %s".formatted(userCreated.getData().getUserName()));
    }

    @Override
    public Set<Class<?>> supports() {
        return Set.of(UserCreated.class);
    }
}
