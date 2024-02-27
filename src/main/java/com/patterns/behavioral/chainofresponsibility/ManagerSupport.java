package com.patterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler - Handles critical priority issues
 */
public class ManagerSupport extends AbstractSupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (canHandle(request, 4)) {
            System.out.println("Manager Support handling: " + request.getIssue());
            System.out.println("  → Immediate escalation to management!\n");
        } else {
            super.handleRequest(request);
        }
    }
}
