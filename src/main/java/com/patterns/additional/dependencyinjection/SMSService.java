package com.patterns.additional.dependencyinjection;

/**
 * Concrete Service - SMS implementation
 */
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient);
        System.out.println("Message: " + message);
        System.out.println("SMS sent successfully!\n");
    }
}
