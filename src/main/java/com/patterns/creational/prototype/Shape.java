package com.patterns.creational.prototype;

/**
 * Prototype Interface - Declares cloning capability
 */
public interface Shape extends Cloneable {
    Shape clone();
    void draw();
    String getType();
}
