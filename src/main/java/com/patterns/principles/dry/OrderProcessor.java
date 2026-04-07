package com.patterns.principles.dry;

/**
 * DRY — correct implementation.
 * Both order types delegate shared logic to PricingUtils.
 * No duplication — a single source of truth for pricing rules.
 */
public class OrderProcessor {

    public double processOnlineOrder(double subtotal, String customerType) {
        double total = PricingUtils.finalTotal(subtotal, customerType);
        System.out.println("[Online] Order total: $" + String.format("%.2f", total));
        return total;
    }

    public double processInStoreOrder(double subtotal, String customerType) {
        double total = PricingUtils.finalTotal(subtotal, customerType);
        System.out.println("[In-Store] Order total: $" + String.format("%.2f", total));
        return total;
    }
}
