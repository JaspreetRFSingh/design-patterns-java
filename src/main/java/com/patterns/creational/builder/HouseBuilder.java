package com.patterns.creational.builder;

/**
 * Builder Interface - Defines steps for building a house
 */
public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void buildGarage();
    void buildSwimmingPool();
    void buildGarden();
    void buildWindows();
    House getHouse();
}
