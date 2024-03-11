package com.patterns.behavioral.mediator;

/**
 * Concrete Colleague - Regular user
 */
public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message, User sender) {
        System.out.println(name + " receives from " + sender.getName() + ": " + message);
    }
}
