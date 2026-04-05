package com.patterns.principles.solid.isp;

/**
 * Robot only implements Workable — the only capability that applies.
 * No forced eat() or sleep() stubs.
 */
public class Robot implements Workable {

    private final String model;

    public Robot(String model) { this.model = model; }

    @Override
    public void work() {
        System.out.println("Robot " + model + " is executing task autonomously.");
    }
}
