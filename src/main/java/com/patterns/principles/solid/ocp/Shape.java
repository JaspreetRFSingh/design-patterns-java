package com.patterns.principles.solid.ocp;

/**
 * Open/Closed Principle — correct implementation.
 * The abstraction is stable (closed for modification).
 * New shapes extend it without touching existing code (open for extension).
 */
public interface Shape {
    double area();
}
