package com.patterns.structural.flyweight;

/**
 * Demo class for Flyweight Pattern
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Pattern Demo ===\n");

        Forest forest = new Forest();

        // Plant many trees with few types
        System.out.println("Planting oak trees:");
        for (int i = 0; i < 5; i++) {
            forest.plantTree(i * 10, i * 10, "Oak", "Green", "Rough");
        }

        System.out.println("\nPlanting pine trees:");
        for (int i = 0; i < 5; i++) {
            forest.plantTree(i * 15, i * 15, "Pine", "Dark Green", "Smooth");
        }

        System.out.println("\nPlanting more oak trees (reusing type):");
        for (int i = 0; i < 3; i++) {
            forest.plantTree(i * 20, i * 20, "Oak", "Green", "Rough");
        }

        System.out.println("\nPlanting birch trees:");
        for (int i = 0; i < 3; i++) {
            forest.plantTree(i * 25, i * 25, "Birch", "White", "Smooth");
        }

        System.out.println("\n=== Forest Status ===");
        System.out.println("Total trees planted: " + forest.getTreeCount());
        System.out.println("Unique tree types: " + TreeFactory.getTreeTypeCount());
        
        TreeFactory.displayTreeTypes();

        System.out.println("\n=== Drawing Forest ===");
        forest.drawForest();

        // Memory comparison
        System.out.println("\n=== Memory Savings ===");
        System.out.println("Without Flyweight: " + (forest.getTreeCount() * 3) + " objects");
        System.out.println("With Flyweight: " + (forest.getTreeCount() + TreeFactory.getTreeTypeCount()) + " objects");
    }
}
