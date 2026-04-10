package com.patterns.principles.lod;

/**
 * Law of Demeter — correct implementation.
 * Person exposes pay() — a meaningful operation — rather than exposing its Wallet.
 * Callers talk to Person only; they don't know about Wallet's internals.
 */
public class Person {

    private final String name;
    private final Wallet wallet;

    public Person(String name, double balance) {
        this.name = name;
        this.wallet = new Wallet(balance);
    }

    public String getName() { return name; }

    public double getBalance() {
        return wallet.getBalance(); // delegates, but doesn't expose the Wallet object
    }

    /**
     * Caller asks the person to pay — the person coordinates with their wallet.
     * Caller has no knowledge of how the wallet works internally.
     */
    public boolean pay(double amount) {
        if (!wallet.hasSufficientFunds(amount)) {
            System.out.println(name + " cannot afford $" + amount);
            return false;
        }
        wallet.deduct(amount);
        System.out.println(name + " paid $" + amount);
        return true;
    }
}
