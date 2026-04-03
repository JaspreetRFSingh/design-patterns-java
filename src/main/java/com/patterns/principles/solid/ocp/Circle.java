package com.patterns.principles.solid.ocp;

/** Concrete shape — no changes needed to AreaCalculator when this is added. */
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() { return "Circle(r=" + radius + ")"; }
}
