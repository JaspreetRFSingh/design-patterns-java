package com.patterns.principles.compositionoverinheritance;

/**
 * Composition over Inheritance — correct implementation.
 * Capabilities are interfaces; vehicles compose only the ones they need.
 */
public interface Drivable {
    void drive();
}
