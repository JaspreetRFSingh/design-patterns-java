package com.patterns.additional.nullobject;

/**
 * Null Object - Provides default do-nothing behavior
 */
public class NullAnimal extends Animal {
    private static NullAnimal instance;

    private NullAnimal() {
        super("Unknown", "Null");
    }

    public static NullAnimal getInstance() {
        if (instance == null) {
            instance = new NullAnimal();
        }
        return instance;
    }

    @Override
    public void makeSound() {
        System.out.println("[No animal - no sound]");
    }

    @Override
    public void move() {
        System.out.println("[No animal - not moving]");
    }

    @Override
    public String getInfo() {
        return "NullAnimal{}";
    }

    @Override
    public String getName() {
        return "N/A";
    }

    @Override
    public String getType() {
        return "N/A";
    }
}
