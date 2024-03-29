package com.patterns.additional.nullobject;

/**
 * Real Object - Actual cat implementation
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name, "Cat");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }

    @Override
    public void move() {
        System.out.println(name + " is walking gracefully");
    }

    @Override
    public String getInfo() {
        return "Cat{name='" + name + "', sound='Meow'}";
    }
}
