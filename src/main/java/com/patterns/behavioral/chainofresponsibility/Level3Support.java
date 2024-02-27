package com.patterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler - Handles high priority (Level 3) issues
 */
public class Level3Support extends AbstractSupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (canHandle(request, 3)) {
            System.out.println("Level 3 Support handling: " + request.getIssue());
            System.out.println("  → Escalating to senior engineer...\n");
        } else {
            super.handleRequest(request);
        }
    }
}
