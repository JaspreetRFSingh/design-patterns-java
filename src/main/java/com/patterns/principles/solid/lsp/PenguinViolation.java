package com.patterns.principles.solid.lsp;

/**
 * VIOLATION of Liskov Substitution Principle.
 * Penguin extends Bird but throws an exception from fly(),
 * breaking the contract that all Birds can fly.
 * Code that uses BirdViolation cannot safely substitute PenguinViolation.
 */
public class PenguinViolation extends BirdViolation {

    public PenguinViolation() { super("Penguin"); }

    @Override
    public void fly() {
        // LSP violation: caller expects flying, but gets an exception
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
}
