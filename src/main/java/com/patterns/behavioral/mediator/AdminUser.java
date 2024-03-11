package com.patterns.behavioral.mediator;

/**
 * Concrete Colleague - Admin user with special privileges
 */
public class AdminUser extends User {

    public AdminUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("[ADMIN] " + name + " broadcasts: " + message);
        mediator.sendMessage("[ADMIN] " + name + ": " + message, this);
    }

    @Override
    public void receiveMessage(String message, User sender) {
        System.out.println("[ADMIN] " + name + " receives from " + sender.getName() + ": " + message);
    }

    public void sendPrivateMessage(String message, User receiver) {
        System.out.println("[ADMIN PRIVATE] " + name + " to " + receiver.getName() + ": " + message);
        ((ChatRoom) mediator).sendPrivateMessage(message, this, receiver);
    }
}
