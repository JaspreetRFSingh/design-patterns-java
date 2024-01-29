package com.patterns.structural.adapter;

/**
 * Demo class for Adapter Pattern
 */
public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo ===\n");

        // Client code works with PaymentProcessor interface
        PaymentProcessor payPal = new PayPalAdapter(new PayPalService());
        PaymentProcessor stripe = new StripeAdapter(new StripeService(), "4111111111111111");

        System.out.println("Processing payment via PayPal:");
        payPal.processPayment(99.99);

        System.out.println("\nProcessing payment via Stripe:");
        stripe.processPayment(149.99);

        System.out.println("\nProcessing refund via PayPal:");
        payPal.refund(99.99);

        System.out.println("\nProcessing refund via Stripe:");
        stripe.refund(149.99);
    }
}
