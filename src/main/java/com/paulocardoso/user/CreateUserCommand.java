package com.paulocardoso.user;

import com.paulocardoso.api.command.Command;

public class CreateUserCommand implements Command<Void> {

    private String userName;

    public CreateUserCommand(String userName){
       this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
