package com.patterns.behavioral.chainofresponsibility;

/**
 * Abstract Handler - Base class for all handlers
 */
public abstract class AbstractSupportHandler implements SupportHandler {
    protected SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for request: " + request);
        }
    }

    protected boolean canHandle(SupportRequest request, int maxPriority) {
        return request.getPriority() <= maxPriority;
    }
}
