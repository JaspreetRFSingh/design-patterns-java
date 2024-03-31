package com.patterns.additional.dependencyinjection;

/**
 * Client - Depends on MessageService (without DI - tightly coupled)
 */
public class MessageClientWithoutDI {
    // Tight coupling - concrete class
    private EmailService messageService;

    public MessageClientWithoutDI() {
        this.messageService = new EmailService(); // Creates dependency
    }

    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
