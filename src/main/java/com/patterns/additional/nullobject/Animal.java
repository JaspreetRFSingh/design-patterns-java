package com.patterns.additional.nullobject;

/**
 * Abstract Class - Base for real and null objects
 */
public abstract class Animal {
    protected String name;
    protected String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract void makeSound();
    public abstract void move();
    public abstract String getInfo();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
