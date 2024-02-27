package com.patterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler - Handles low priority (Level 1) issues
 */
public class Level1Support extends AbstractSupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (canHandle(request, 1)) {
            System.out.println("Level 1 Support handling: " + request.getIssue());
            System.out.println("  → Providing basic troubleshooting steps...\n");
        } else {
            super.handleRequest(request);
        }
    }
}
