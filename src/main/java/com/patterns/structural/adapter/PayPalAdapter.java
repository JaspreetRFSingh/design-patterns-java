package com.patterns.structural.adapter;

/**
 * Adapter - Makes PayPalService compatible with PaymentProcessor
 */
public class PayPalAdapter implements PaymentProcessor {
    private PayPalService payPalService;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void processPayment(double amount) {
        payPalService.authenticate();
        payPalService.sendPayment(amount);
    }

    @Override
    public void refund(double amount) {
        payPalService.receiveRefund(amount);
    }
}
