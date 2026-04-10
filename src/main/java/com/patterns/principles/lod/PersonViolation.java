package com.patterns.principles.lod;

/**
 * VIOLATION of Law of Demeter.
 * Callers reach through three objects to accomplish a simple operation.
 * The caller knows about Person, Wallet, AND Money — too much knowledge.
 */
public class PersonViolation {

    private final String name;
    private final WalletViolation wallet;

    public PersonViolation(String name, double balance) {
        this.name = name;
        this.wallet = new WalletViolation(balance);
    }

    public String getName() { return name; }

    // Exposes the wallet — enabling the violation
    public WalletViolation getWallet() { return wallet; }
}
