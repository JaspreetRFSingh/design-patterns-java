package com.patterns.additional.dependencyinjection;

/**
 * Client - Depends on MessageService (with DI - loosely coupled)
 */
public class MessageClient {
    // Dependency is injected
    private MessageService messageService;

    // Constructor Injection
    public MessageClient(MessageService messageService) {
        this.messageService = messageService;
    }

    // Setter Injection (alternative)
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
