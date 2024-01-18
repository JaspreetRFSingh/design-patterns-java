package com.patterns.creational.builder;

/**
 * Concrete Builder - Builds a concrete house
 */
public class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House.Builder("Concrete Foundation", "Concrete Structure", "Tile Roof")
                .build();
    }

    @Override
    public void buildFoundation() {
        System.out.println("Pouring concrete foundation...");
    }

    @Override
    public void buildStructure() {
        System.out.println("Building concrete structure...");
    }

    @Override
    public void buildRoof() {
        System.out.println("Installing tile roof...");
    }

    @Override
    public void buildGarage() {
        System.out.println("Building attached garage...");
    }

    @Override
    public void buildSwimmingPool() {
        System.out.println("Excavating and building swimming pool...");
    }

    @Override
    public void buildGarden() {
        System.out.println("Creating landscaped garden...");
    }

    @Override
    public void buildWindows() {
        System.out.println("Installing energy-efficient windows...");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
