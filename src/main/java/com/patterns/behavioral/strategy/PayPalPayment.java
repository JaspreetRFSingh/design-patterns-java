package com.patterns.behavioral.strategy;

/**
 * Concrete Strategy - PayPal payment
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Account: " + email);
        System.out.println("Payment successful!\n");
    }
}
