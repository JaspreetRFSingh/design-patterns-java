package com.patterns.principles.dry;

/**
 * DRY — correct implementation.
 * Shared pricing logic lives in one place. A rule change here propagates everywhere.
 */
public class PricingUtils {

    public static double applyDiscount(double subtotal, String customerType) {
        return switch (customerType) {
            case "PREMIUM" -> subtotal * (1 - 0.15);
            case "REGULAR" -> subtotal * (1 - 0.05);
            default        -> subtotal;
        };
    }

    public static double applyTax(double amount) {
        return amount * 1.08;
    }

    public static double finalTotal(double subtotal, String customerType) {
        return applyTax(applyDiscount(subtotal, customerType));
    }
}
