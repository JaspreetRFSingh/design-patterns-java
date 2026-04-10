package com.patterns.principles.lod;

/**
 * Law of Demeter — correct implementation.
 * Wallet manages its own balance and exposes only high-level operations.
 * Internal representation (Money class) is no longer needed.
 */
public class Wallet {

    private double balance;

    public Wallet(double balance) { this.balance = balance; }

    public double getBalance() { return balance; }

    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        if (!hasSufficientFunds(amount)) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        System.out.println("  Wallet deducted $" + amount + ". Remaining: $" + balance);
    }
}
