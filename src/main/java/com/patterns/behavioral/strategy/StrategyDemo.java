package com.patterns.behavioral.strategy;

/**
 * Demo class for Strategy Pattern
 */
public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo ===\n");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(29.99);
        cart.addItem(19.99);
        cart.addItem(49.99);

        System.out.println("Cart total: $" + cart.getTotal() + "\n");

        // Pay with credit card
        System.out.println("--- Payment with Credit Card ---");
        cart.setPaymentStrategy(new CreditCardPayment("1234567812345678", "123", "12/25"));
        cart.checkout();

        // Add more items
        cart.addItem(99.99);
        System.out.println("New cart total: $" + cart.getTotal() + "\n");

        // Pay with PayPal
        System.out.println("--- Payment with PayPal ---");
        cart.setPaymentStrategy(new PayPalPayment("user@example.com", "password123"));
        cart.checkout();

        // Add more items
        cart.addItem(199.99);
        System.out.println("New cart total: $" + cart.getTotal() + "\n");

        // Pay with Bitcoin
        System.out.println("--- Payment with Bitcoin ---");
        cart.setPaymentStrategy(new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        cart.checkout();
    }
}
