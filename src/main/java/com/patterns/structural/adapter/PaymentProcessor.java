package com.patterns.structural.adapter;

/**
 * Target Interface - What the client expects
 */
public interface PaymentProcessor {
    void processPayment(double amount);
    void refund(double amount);
}
