package com.patterns.principles.dry;

/**
 * Demonstrates the DRY (Don't Repeat Yourself) principle.
 */
public class DRYDemo {

    public static void main(String[] args) {
        System.out.println("=== DRY Violation ===");
        OrderProcessorViolation bad = new OrderProcessorViolation();
        bad.processOnlineOrder(100.0, "PREMIUM");
        bad.processInStoreOrder(100.0, "PREMIUM");
        System.out.println("(Discount/tax logic is duplicated in both methods)");

        System.out.println();
        System.out.println("=== DRY Correct Implementation ===");
        OrderProcessor good = new OrderProcessor();
        good.processOnlineOrder(100.0, "PREMIUM");
        good.processInStoreOrder(100.0, "PREMIUM");

        System.out.println();
        System.out.println("-- Changing tax rate now requires editing PricingUtils only --");
        System.out.printf("PREMIUM discount on $200: $%.2f%n", PricingUtils.applyDiscount(200, "PREMIUM"));
        System.out.printf("REGULAR discount on $200: $%.2f%n", PricingUtils.applyDiscount(200, "REGULAR"));
    }
}
