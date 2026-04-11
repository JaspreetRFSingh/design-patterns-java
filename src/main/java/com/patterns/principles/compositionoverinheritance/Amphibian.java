package com.patterns.principles.compositionoverinheritance;

/** Amphibian vehicle — can drive and swim. No inheritance hierarchy needed. */
public class Amphibian implements Drivable, Swimmable {

    private final String name;

    public Amphibian(String name) { this.name = name; }

    @Override
    public void drive() {
        System.out.println(name + " is driving on land.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming through the water.");
    }
}
