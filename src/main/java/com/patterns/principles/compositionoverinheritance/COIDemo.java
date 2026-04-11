package com.patterns.principles.compositionoverinheritance;

import java.util.List;

/**
 * Demonstrates the Composition over Inheritance principle.
 */
public class COIDemo {

    public static void main(String[] args) {
        System.out.println("=== Inheritance Violation ===");
        CarViolation badCar = new CarViolation("BadCar");
        badCar.drive();
        try {
            badCar.fly(); // inherited but unusable — LSP violation
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Composition over Inheritance ===");

        Car car = new Car("Tesla Model 3");
        Airplane plane = new Airplane("Boeing 737");
        Amphibian dukw = new Amphibian("DUKW");
        FlyingCar futureCar = new FlyingCar("AeroMobil");

        System.out.println("-- All drivable vehicles --");
        List<Drivable> drivables = List.of(car, plane, dukw, futureCar);
        drivables.forEach(Drivable::drive);

        System.out.println();
        System.out.println("-- Flying vehicles only --");
        List<Flyable> flyers = List.of(plane, futureCar);
        flyers.forEach(Flyable::fly);

        System.out.println();
        System.out.println("-- Swimming vehicles only --");
        List<Swimmable> swimmers = List.of(dukw, futureCar);
        swimmers.forEach(Swimmable::swim);

        System.out.println();
        System.out.println("Each vehicle composes only the capabilities it actually has.");
    }
}
