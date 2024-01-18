package com.patterns.creational.builder;

/**
 * Director - Constructs the product using the builder
 */
public class ConstructionEngineer {
    private HouseBuilder houseBuilder;

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        System.out.println("\nStarting house construction...");
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.buildWindows();
        houseBuilder.buildGarage();
        houseBuilder.buildSwimmingPool();
        houseBuilder.buildGarden();
        System.out.println("House construction completed!\n");
        return houseBuilder.getHouse();
    }
}
