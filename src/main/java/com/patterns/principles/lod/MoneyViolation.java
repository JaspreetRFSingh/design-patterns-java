package com.patterns.principles.lod;

/** Internal detail of WalletViolation — should not be accessed from outside. */
public class MoneyViolation {

    private double amount;

    public MoneyViolation(double amount) { this.amount = amount; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
