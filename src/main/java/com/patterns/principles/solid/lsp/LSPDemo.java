package com.patterns.principles.solid.lsp;

import java.util.List;

/**
 * Demonstrates the Liskov Substitution Principle (LSP).
 */
public class LSPDemo {

    public static void main(String[] args) {
        System.out.println("=== LSP Violation ===");
        List<BirdViolation> badBirds = List.of(
                new BirdViolation("Eagle"),
                new PenguinViolation()
        );
        for (BirdViolation bird : badBirds) {
            try {
                bird.fly(); // throws for Penguin — LSP broken
            } catch (UnsupportedOperationException e) {
                System.out.println("ERROR: " + e.getMessage() + " (caller didn't expect this!)");
            }
        }

        System.out.println();
        System.out.println("=== LSP Correct Implementation ===");
        List<Bird> birds = List.of(new Eagle(), new Penguin(), new Sparrow());

        System.out.println("-- All birds can be described safely --");
        for (Bird b : birds) {
            System.out.println(b.describe());
        }

        System.out.println();
        System.out.println("-- Only flying birds fly --");
        for (Bird b : birds) {
            if (b instanceof Flyable f) {
                f.fly();
            } else {
                System.out.println(b.getName() + " cannot fly — and that's fine.");
            }
        }

        System.out.println();
        System.out.println("-- Penguin-specific behaviour --");
        Penguin penguin = new Penguin();
        penguin.swim();
    }
}
