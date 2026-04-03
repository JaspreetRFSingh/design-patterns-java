package com.patterns.principles.solid.ocp;

/** Used in the OCP violation example — a plain data class with no abstraction. */
public class CircleViolation {
    private final double radius;
    public CircleViolation(double radius) { this.radius = radius; }
    public double getRadius() { return radius; }
}
