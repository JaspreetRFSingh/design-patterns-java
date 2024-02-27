package com.patterns.behavioral.chainofresponsibility;

/**
 * Demo class for Chain of Responsibility Pattern
 */
public class ChainDemo {
    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility Pattern Demo ===\n");

        // Create handlers
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        SupportHandler manager = new ManagerSupport();

        // Build the chain
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        level3.setNextHandler(manager);

        // Create support requests with different priorities
        SupportRequest[] requests = {
            new SupportRequest("Password reset", 1),
            new SupportRequest("Software installation issue", 2),
            new SupportRequest("Database connection failure", 3),
            new SupportRequest("Server down - production", 4),
            new SupportRequest("How to use the app?", 1)
        };

        // Process requests through the chain
        System.out.println("Processing support requests:\n");
        for (SupportRequest request : requests) {
            System.out.println("Received: " + request);
            level1.handleRequest(request);
        }
    }
}
