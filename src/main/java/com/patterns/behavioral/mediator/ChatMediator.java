package com.patterns.behavioral.mediator;

/**
 * Mediator Interface - Defines communication contract
 */
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
