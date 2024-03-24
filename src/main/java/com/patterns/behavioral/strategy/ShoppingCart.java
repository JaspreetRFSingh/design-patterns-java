package com.patterns.behavioral.strategy;

/**
 * Context - Shopping cart that uses payment strategy
 */
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double total;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addItem(double price) {
        total += price;
    }

    public double getTotal() {
        return total;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method");
            return;
        }
        System.out.println("=== Checkout ===");
        System.out.println("Total: $" + total);
        paymentStrategy.pay(total);
    }
}
