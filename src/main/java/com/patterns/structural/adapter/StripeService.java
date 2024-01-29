package com.patterns.structural.adapter;

/**
 * Another Adaptee - Stripe payment service
 */
public class StripeService {
    public void chargeCard(double amount, String cardNumber) {
        System.out.println("Charging $" + amount + " to card ending " + cardNumber.substring(cardNumber.length() - 4));
    }

    public void issueRefund(String transactionId, double amount) {
        System.out.println("Refunding $" + amount + " for transaction " + transactionId);
    }
}
