package com.patterns.principles.solid.ocp;

/** New shape added without touching AreaCalculator — OCP in action. */
public class Triangle implements Shape {
    private final double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() { return "Triangle(base=" + base + ", height=" + height + ")"; }
}
