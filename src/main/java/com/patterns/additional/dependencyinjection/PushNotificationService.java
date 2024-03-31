package com.patterns.additional.dependencyinjection;

/**
 * Concrete Service - Push notification implementation
 */
public class PushNotificationService implements MessageService {
    private String apiKey;

    public PushNotificationService(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Sending PUSH NOTIFICATION to " + recipient);
        System.out.println("Using API Key: " + apiKey);
        System.out.println("Message: " + message);
        System.out.println("Push notification sent successfully!\n");
    }
}
