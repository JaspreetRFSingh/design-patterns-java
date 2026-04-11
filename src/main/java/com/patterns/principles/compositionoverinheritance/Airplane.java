package com.patterns.principles.compositionoverinheritance;

/** Airplane can drive (taxi) and fly. */
public class Airplane implements Drivable, Flyable {

    private final String name;

    public Airplane(String name) { this.name = name; }

    @Override
    public void drive() {
        System.out.println(name + " is taxiing on the runway.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is cruising at 35,000 feet!");
    }
}
