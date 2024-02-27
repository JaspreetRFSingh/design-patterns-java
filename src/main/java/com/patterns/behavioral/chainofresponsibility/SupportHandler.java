package com.patterns.behavioral.chainofresponsibility;

/**
 * Handler Interface - Defines the request handling contract
 */
public interface SupportHandler {
    void handleRequest(SupportRequest request);
    void setNextHandler(SupportHandler nextHandler);
}
