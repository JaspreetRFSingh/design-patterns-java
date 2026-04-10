package com.patterns.principles.lod;

/**
 * Used in the Law of Demeter violation example.
 * Callers reach through Person → Wallet → Money to get the amount.
 */
public class WalletViolation {

    private MoneyViolation money;

    public WalletViolation(double amount) {
        this.money = new MoneyViolation(amount);
    }

    // Exposes internal Money object — enables method chaining violation
    public MoneyViolation getMoney() {
        return money;
    }

    public void deductMoney(double amount) {
        money.setAmount(money.getAmount() - amount);
    }
}
