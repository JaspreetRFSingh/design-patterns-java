package com.patterns.structural.adapter;

/**
 * Another Adapter - Makes StripeService compatible with PaymentProcessor
 */
public class StripeAdapter implements PaymentProcessor {
    private StripeService stripeService;
    private String defaultCard;

    public StripeAdapter(StripeService stripeService, String defaultCard) {
        this.stripeService = stripeService;
        this.defaultCard = defaultCard;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.chargeCard(amount, defaultCard);
    }

    @Override
    public void refund(double amount) {
        stripeService.issueRefund("TXN-" + System.currentTimeMillis(), amount);
    }
}
