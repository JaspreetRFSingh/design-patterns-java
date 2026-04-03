package com.patterns.principles.solid.ocp;

/** Used in the OCP violation example — a plain data class with no abstraction. */
public class RectangleViolation {
    private final double width, height;
    public RectangleViolation(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}
