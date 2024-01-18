package com.patterns.creational.builder;

/**
 * Concrete Builder - Builds a wooden house
 */
public class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House.Builder("Wooden Foundation", "Wooden Structure", "Wooden Roof")
                .build();
    }

    @Override
    public void buildFoundation() {
        System.out.println("Building wooden foundation...");
    }

    @Override
    public void buildStructure() {
        System.out.println("Building wooden structure...");
    }

    @Override
    public void buildRoof() {
        System.out.println("Building wooden roof...");
    }

    @Override
    public void buildGarage() {
        System.out.println("Adding wooden garage...");
    }

    @Override
    public void buildSwimmingPool() {
        System.out.println("Wooden houses don't have swimming pools!");
    }

    @Override
    public void buildGarden() {
        System.out.println("Landscaping garden around wooden house...");
    }

    @Override
    public void buildWindows() {
        System.out.println("Installing wooden-framed windows...");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
