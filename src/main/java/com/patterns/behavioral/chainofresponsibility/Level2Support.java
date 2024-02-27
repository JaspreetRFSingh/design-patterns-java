package com.patterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler - Handles medium priority (Level 2) issues
 */
public class Level2Support extends AbstractSupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (canHandle(request, 2)) {
            System.out.println("Level 2 Support handling: " + request.getIssue());
            System.out.println("  → Performing advanced diagnostics...\n");
        } else {
            super.handleRequest(request);
        }
    }
}
