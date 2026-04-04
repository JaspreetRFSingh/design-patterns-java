package com.patterns.principles.solid.lsp;

/**
 * VIOLATION of Liskov Substitution Principle — base class in the bad example.
 * The contract implied by fly() is broken by PenguinViolation.
 */
public class BirdViolation {

    public String name;

    public BirdViolation(String name) { this.name = name; }

    /** Contract: birds can fly. But Penguin will violate this! */
    public void fly() {
        System.out.println(name + " is flying!");
    }
}
