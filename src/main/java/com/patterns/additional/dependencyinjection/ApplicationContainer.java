package com.patterns.additional.dependencyinjection;

/**
 * Container/Injector - Creates and wires objects
 */
public class ApplicationContainer {
    private MessageService messageService;
    private MessageClient messageClient;

    public ApplicationContainer() {
        // Create services
        messageService = new EmailService();
        
        // Inject dependency
        messageClient = new MessageClient(messageService);
    }

    public ApplicationContainer(MessageService service) {
        // Allow custom service injection
        messageService = service;
        messageClient = new MessageClient(service);
    }

    public MessageClient getMessageClient() {
        return messageClient;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService service) {
        this.messageService = service;
        this.messageClient = new MessageClient(service);
    }
}
