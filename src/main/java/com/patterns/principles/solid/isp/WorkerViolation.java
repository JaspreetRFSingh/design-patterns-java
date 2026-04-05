package com.patterns.principles.solid.isp;

/**
 * VIOLATION of Interface Segregation Principle.
 * A single fat interface forces all implementors to provide methods
 * that may be irrelevant to them.
 */
public interface WorkerViolation {
    void work();
    void eat();   // Robots don't eat
    void sleep(); // Robots don't sleep
}
