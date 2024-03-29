package com.patterns.additional.nullobject;

/**
 * Real Object - Actual dog implementation
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name, "Dog");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println(name + " is running on four legs");
    }

    @Override
    public String getInfo() {
        return "Dog{name='" + name + "', sound='Woof'}";
    }
}
