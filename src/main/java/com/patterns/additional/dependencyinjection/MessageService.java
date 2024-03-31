package com.patterns.additional.dependencyinjection;

/**
 * Service Interface - Contract for message services
 */
public interface MessageService {
    void sendMessage(String message, String recipient);
}
