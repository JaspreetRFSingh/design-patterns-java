package com.patterns.additional.nullobject;

/**
 * Demo class for Null Object Pattern
 */
public class NullObjectDemo {
    public static void main(String[] args) {
        System.out.println("=== Null Object Pattern Demo ===\n");

        AnimalRegistry registry = new AnimalRegistry();
        registry.registerAnimal("pet1", new Dog("Buddy"));
        registry.registerAnimal("pet2", new Cat("Whiskers"));

        System.out.println("--- Getting existing animals ---");
        Animal pet1 = registry.getAnimal("pet1");
        pet1.makeSound();
        pet1.move();
        System.out.println("Info: " + pet1.getInfo());

        System.out.println("\n--- Getting non-existent animal ---");
        Animal unknown = registry.getAnimal("pet999");
        unknown.makeSound();
        unknown.move();
        System.out.println("Info: " + unknown.getInfo());

        System.out.println("\n--- No null checks needed ---");
        // Client code doesn't need null checks
        Animal[] animals = {
            registry.getAnimal("pet1"),
            registry.getAnimal("pet2"),
            registry.getAnimal("nonexistent")
        };

        for (Animal animal : animals) {
            animal.makeSound(); // Safe - no NullPointerException
        }
    }
}
