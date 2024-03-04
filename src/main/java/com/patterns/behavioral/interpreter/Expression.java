package com.patterns.behavioral.interpreter;

/**
 * Abstract Expression - Base interface for all expressions
 */
public interface Expression {
    boolean interpret(String context);
}
