package com.patterns.behavioral.strategy;

/**
 * Strategy Interface - Defines payment processing contract
 */
public interface PaymentStrategy {
    void pay(double amount);
}
