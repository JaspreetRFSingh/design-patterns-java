package com.patterns.principles.lod;

/**
 * Demonstrates the Law of Demeter (Principle of Least Knowledge).
 */
public class LODDemo {

    public static void main(String[] args) {
        System.out.println("=== Law of Demeter Violation ===");
        PersonViolation badPerson = new PersonViolation("Alice", 100.0);

        // Caller navigates a chain: person → wallet → money → amount
        // This is "train-wreck" code — caller knows three object internals
        double balance = badPerson.getWallet().getMoney().getAmount();
        System.out.println(badPerson.getName() + "'s balance: $" + balance);

        // To deduct, caller again traverses the chain
        badPerson.getWallet().deductMoney(30.0);
        System.out.println("After deduction: $" + badPerson.getWallet().getMoney().getAmount());
        System.out.println("(Caller depends on Person, WalletViolation, AND MoneyViolation)");

        System.out.println();
        System.out.println("=== Law of Demeter Correct Implementation ===");
        Person alice = new Person("Alice", 100.0);

        // Caller only talks to Person — clean, readable, decoupled
        System.out.println(alice.getName() + "'s balance: $" + alice.getBalance());
        alice.pay(30.0);
        alice.pay(80.0); // insufficient funds
        System.out.println("Final balance: $" + alice.getBalance());
        System.out.println("(Caller only depends on Person — knows nothing about Wallet)");
    }
}
