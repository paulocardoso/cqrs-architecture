package com.paulocardoso.user;

import com.paulocardoso.api.command.CommandHandler;
import com.paulocardoso.api.event.EventBus;

import java.util.logging.Logger;

public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, Void> {

    public static Logger LOGGER = Logger.getLogger(CreateUserCommand.class.getName());

    final EventBus eventBus;

    final WriteUserRepository writeUserRepository;

    public CreateUserCommandHandler(EventBus eventBus, WriteUserRepository writeUserRepository) {
        this.eventBus = eventBus;
        this.writeUserRepository = writeUserRepository;
    }

    public Void handle(CreateUserCommand command) {

        var user = new User(command.getUserName());
        writeUserRepository.save(user);

        LOGGER.info("Command: %s".formatted(writeUserRepository.getEntities()));

        eventBus.dispatch(new UserCreated(user));

        return null;
    }
}
