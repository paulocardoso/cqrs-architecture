package com.paulocardoso.user;

import com.paulocardoso.api.event.Subscribable;

import java.util.Set;
import java.util.logging.Logger;

public class UserCreatedEventHandler implements Subscribable<UserCreated> {

    public static Logger LOGGER = Logger.getLogger(UserCreatedEventHandler.class.getName());

    @Override
    public void handle(UserCreated event) {
        LOGGER.info("User Created %s".formatted(event.getData().getUserName()));
    }

    @Override
    public Set<Class<?>> supports() {
        return Set.of(UserCreated.class);
    }
}
