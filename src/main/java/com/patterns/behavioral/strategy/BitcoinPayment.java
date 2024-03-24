package com.patterns.behavioral.strategy;

/**
 * Concrete Strategy - Bitcoin payment
 */
public class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        double btcAmount = amount / 45000; // Example rate
        System.out.println("Processing Bitcoin payment of $" + amount);
        System.out.println("Wallet: " + walletAddress);
        System.out.println("Amount: " + String.format("%.6f", btcAmount) + " BTC");
        System.out.println("Payment successful!\n");
    }
}
