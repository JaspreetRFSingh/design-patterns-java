package com.patterns.principles.compositionoverinheritance;

/** Car only implements Drivable — no phantom fly/swim methods. */
public class Car implements Drivable {

    private final String name;

    public Car(String name) { this.name = name; }

    @Override
    public void drive() {
        System.out.println(name + " is driving on the road.");
    }
}
