package com.paulocardoso.user;

import com.paulocardoso.api.command.CommandBus;


public class UserAPI {

    CommandBus commandBus;

    public User createUser(User user){
        return commandBus.execute(new CreateUserCommand(user.getUserName()));
    }
}
