package com.patterns.principles.solid.dip;

/**
 * Dependency Inversion Principle — correct implementation.
 * Both high-level and low-level modules depend on THIS abstraction.
 * Neither depends on the other directly.
 */
public interface ReportFormatter {
    String format(String data);
    String formatName();
}
