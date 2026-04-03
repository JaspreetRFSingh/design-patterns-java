package com.patterns.principles.solid.ocp;

/** Concrete shape — no changes needed to AreaCalculator when this is added. */
public class Rectangle implements Shape {
    private final double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() { return "Rectangle(" + width + "x" + height + ")"; }
}
