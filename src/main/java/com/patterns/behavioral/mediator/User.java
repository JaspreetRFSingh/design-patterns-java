package com.patterns.behavioral.mediator;

/**
 * Colleague Interface - User in the chat
 */
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message, User sender);

    public String getName() {
        return name;
    }
}
