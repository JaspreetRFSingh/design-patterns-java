package com.patterns.principles.compositionoverinheritance;

/**
 * VIOLATION — using inheritance to share behaviour.
 * A FlyingCar must extend both Car and Plane, but Java has no multiple inheritance.
 * Even with single inheritance, deep hierarchies become brittle and hard to change.
 */
public class VehicleViolation {

    protected String name;

    public VehicleViolation(String name) { this.name = name; }

    // All vehicles drive — but not all vehicles fly or swim
    public void drive() {
        System.out.println(name + " is driving.");
    }

    // Putting fly() here forces every vehicle subclass to deal with flying
    public void fly() {
        throw new UnsupportedOperationException(name + " cannot fly!");
    }

    // Putting swim() here forces every vehicle subclass to deal with swimming
    public void swim() {
        throw new UnsupportedOperationException(name + " cannot swim!");
    }
}
