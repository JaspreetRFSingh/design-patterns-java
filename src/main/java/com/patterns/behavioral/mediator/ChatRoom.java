package com.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Mediator - Chat room that coordinates users
 */
public class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Don't send message to sender
            if (user != sender) {
                user.receiveMessage(message, sender);
            }
        }
    }

    public void sendPrivateMessage(String message, User sender, User receiver) {
        receiver.receiveMessage("[Private from " + sender.getName() + "] " + message, sender);
    }
}
