package com.paulocardoso.user;

import com.paulocardoso.api.command.CommandHandler;
import com.paulocardoso.api.event.EventBus;
import com.paulocardoso.api.event.EventBusImpl;

import java.util.logging.Logger;

public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, Void> {

    public static Logger LOGGER = Logger.getLogger(CreateUserCommand.class.getName());

    final EventBus eventBus;

    public CreateUserCommandHandler(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public Void handle(CreateUserCommand command) {

        var user = new User(command.getUserName());

        UserRepository userRepository = new UserRepository();
        userRepository.save(user);
        LOGGER.info("Command: %s".formatted(userRepository.getEntities()));

        eventBus.dispatch(new UserCreated(user));

        return null;
    }
}
