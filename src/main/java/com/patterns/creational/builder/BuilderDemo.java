package com.patterns.creational.builder;

/**
 * Demo class for Builder Pattern
 */
public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===");

        // Using the Director with different builders
        ConstructionEngineer engineer = new ConstructionEngineer(new WoodenHouseBuilder());
        House woodenHouse = engineer.constructHouse();
        System.out.println("Wooden House: " + woodenHouse);

        // Change builder to construct a different type
        engineer.setHouseBuilder(new ConcreteHouseBuilder());
        House concreteHouse = engineer.constructHouse();
        System.out.println("Concrete House: " + concreteHouse);

        // Using the fluent builder directly
        System.out.println("\n=== Fluent Builder Demo ===");
        House customHouse = new House.Builder("Steel Foundation", "Steel Frame", "Metal Roof")
                .setHasGarage(true)
                .setHasSwimmingPool(true)
                .setHasGarden(true)
                .setNumberOfWindows(12)
                .build();
        System.out.println("Custom House: " + customHouse);
    }
}
