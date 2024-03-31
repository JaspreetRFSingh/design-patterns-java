package com.patterns.additional.dependencyinjection;

/**
 * Demo class for Dependency Injection Pattern
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Pattern Demo ===\n");

        // Without DI - tightly coupled
        System.out.println("--- Without DI (Tightly Coupled) ---");
        MessageClientWithoutDI clientWithoutDI = new MessageClientWithoutDI();
        clientWithoutDI.processMessage("Hello", "user@example.com");

        // With Constructor Injection
        System.out.println("--- With Constructor Injection (Email) ---");
        MessageService emailService = new EmailService();
        MessageClient emailClient = new MessageClient(emailService);
        emailClient.processMessage("Hello via Email", "user@example.com");

        // With Constructor Injection (SMS)
        System.out.println("--- With Constructor Injection (SMS) ---");
        MessageService smsService = new SMSService();
        MessageClient smsClient = new MessageClient(smsService);
        smsClient.processMessage("Hello via SMS", "+1234567890");

        // With Container
        System.out.println("--- Using Application Container ---");
        ApplicationContainer container = new ApplicationContainer();
        container.getMessageClient().processMessage("Hello from Container", "user@test.com");

        // Switch service at runtime
        System.out.println("--- Switching Service at Runtime ---");
        container.setMessageService(new PushNotificationService("API-KEY-123"));
        container.getMessageClient().processMessage("Hello via Push", "device-token-456");

        // With Setter Injection
        System.out.println("--- With Setter Injection ---");
        MessageClient setterClient = new MessageClient(new EmailService());
        setterClient.processMessage("Initial message", "user@example.com");
        
        // Change dependency
        setterClient.setMessageService(new SMSService());
        setterClient.processMessage("Changed to SMS", "+1234567890");
    }
}
