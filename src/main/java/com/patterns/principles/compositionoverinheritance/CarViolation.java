package com.patterns.principles.compositionoverinheritance;

/** Inherits fly() and swim() from Vehicle even though it uses neither. */
public class CarViolation extends VehicleViolation {
    public CarViolation(String name) { super(name); }
    // drive() works fine, but fly() and swim() throw — LSP violation
}
