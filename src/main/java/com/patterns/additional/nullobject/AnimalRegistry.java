package com.patterns.additional.nullobject;

import java.util.HashMap;
import java.util.Map;

/**
 * Animal Registry - Manages animals and returns null object when not found
 */
public class AnimalRegistry {
    private Map<String, Animal> animals = new HashMap<>();

    public void registerAnimal(String id, Animal animal) {
        animals.put(id, animal);
    }

    public Animal getAnimal(String id) {
        Animal animal = animals.get(id);
        if (animal == null) {
            System.out.println("Animal with id '" + id + "' not found, returning NullAnimal");
            return NullAnimal.getInstance();
        }
        return animal;
    }

    public void displayAllAnimals() {
        for (Map.Entry<String, Animal> entry : animals.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            entry.getValue().makeSound();
        }
    }
}
