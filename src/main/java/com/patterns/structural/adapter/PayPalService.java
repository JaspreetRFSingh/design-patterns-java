package com.patterns.structural.adapter;

/**
 * Adaptee - Third-party payment service with incompatible interface
 */
public class PayPalService {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    public void receiveRefund(double amount) {
        System.out.println("Processing PayPal refund of $" + amount);
    }

    public void authenticate() {
        System.out.println("Authenticating with PayPal...");
    }
}
