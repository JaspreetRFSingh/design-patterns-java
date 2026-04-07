package com.patterns.principles.dry;

/**
 * VIOLATION of DRY (Don't Repeat Yourself).
 * The same discount and tax calculation logic is copy-pasted in two methods.
 * A bug or rule change must be fixed in multiple places.
 */
public class OrderProcessorViolation {

    public double processOnlineOrder(double subtotal, String customerType) {
        // Duplicated discount logic
        double discount = 0;
        if ("PREMIUM".equals(customerType)) {
            discount = subtotal * 0.15;
        } else if ("REGULAR".equals(customerType)) {
            discount = subtotal * 0.05;
        }
        double afterDiscount = subtotal - discount;

        // Duplicated tax logic
        double tax = afterDiscount * 0.08;
        double total = afterDiscount + tax;

        System.out.println("[Online] Order total: $" + String.format("%.2f", total));
        return total;
    }

    public double processInStoreOrder(double subtotal, String customerType) {
        // Same discount logic — copy-pasted
        double discount = 0;
        if ("PREMIUM".equals(customerType)) {
            discount = subtotal * 0.15;
        } else if ("REGULAR".equals(customerType)) {
            discount = subtotal * 0.05;
        }
        double afterDiscount = subtotal - discount;

        // Same tax logic — copy-pasted
        double tax = afterDiscount * 0.08;
        double total = afterDiscount + tax;

        System.out.println("[In-Store] Order total: $" + String.format("%.2f", total));
        return total;
    }
}
