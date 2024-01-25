package com.patterns.creational.prototype;

/**
 * Demo class for Prototype Pattern
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demo ===\n");

        ShapeRegistry registry = new ShapeRegistry();

        // Get cloned shapes from registry
        System.out.println("Creating shapes from prototypes:");
        Shape shape1 = registry.getShape("Circle");
        shape1.draw();
        System.out.println("Shape 1: " + shape1);

        Shape shape2 = registry.getShape("Rectangle");
        shape2.draw();
        System.out.println("Shape 2: " + shape2);

        // Modify cloned shapes independently
        System.out.println("\nModifying cloned shapes:");
        if (shape1 instanceof Circle) {
            Circle circle = (Circle) shape1;
            circle.setX(100);
            circle.setY(100);
            circle.setRadius(50);
            circle.setColor("green");
        }
        shape1.draw();
        System.out.println("Modified Shape 1: " + shape1);

        // Original prototype unchanged
        System.out.println("\nOriginal prototype unchanged:");
        Shape shape3 = registry.getShape("Circle");
        shape3.draw();
        System.out.println("Shape 3: " + shape3);

        // Verify they are different instances
        System.out.println("\nAre shape1 and shape3 the same object? " + (shape1 == shape3));
    }
}
