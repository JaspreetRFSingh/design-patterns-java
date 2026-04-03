package com.patterns.principles.solid.ocp;

/**
 * VIOLATION of Open/Closed Principle.
 * Every time a new shape is added, this class must be modified.
 * This class is "open for modification" but should be "closed" to it.
 */
public class AreaCalculatorViolation {

    // Adding a new shape (e.g., Triangle) forces editing this method
    public double calculateArea(Object shape) {
        if (shape instanceof CircleViolation c) {
            return Math.PI * c.getRadius() * c.getRadius();
        } else if (shape instanceof RectangleViolation r) {
            return r.getWidth() * r.getHeight();
        }
        // Must add another else-if for every new shape — violates OCP
        throw new IllegalArgumentException("Unknown shape: " + shape.getClass());
    }
}
