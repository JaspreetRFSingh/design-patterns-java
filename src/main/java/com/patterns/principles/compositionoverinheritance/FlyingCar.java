package com.patterns.principles.compositionoverinheritance;

/**
 * FlyingCar composes all three capabilities with zero hierarchy trouble.
 * In pure inheritance, this would require multiple inheritance — impossible in Java.
 */
public class FlyingCar implements Drivable, Flyable, Swimmable {

    private final String name;

    public FlyingCar(String name) { this.name = name; }

    @Override
    public void drive() {
        System.out.println(name + " is driving through the city.");
    }

    @Override
    public void fly() {
        System.out.println(name + " has deployed wings and is flying!");
    }

    @Override
    public void swim() {
        System.out.println(name + " has deployed pontoons and is crossing the river!");
    }
}
