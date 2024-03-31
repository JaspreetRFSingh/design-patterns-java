package com.patterns.additional.dependencyinjection;

/**
 * Concrete Service - Email implementation
 */
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Sending EMAIL to " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Email sent successfully!\n");
    }
}
