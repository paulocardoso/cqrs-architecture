package com.paulocardoso.user;

import com.paulocardoso.api.event.Event;

public class UserCreated implements Event<User> {

    private final User user;

    public UserCreated(User user) {
        this.user = user;
    }

    @Override
    public User getData() {
        return user;
    }
}
