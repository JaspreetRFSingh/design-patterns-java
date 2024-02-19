package com.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory - Manages shared TreeType objects
 */
public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        
        if (!treeTypes.containsKey(key)) {
            System.out.println("Creating new TreeType: " + name);
            treeTypes.put(key, new TreeType(name, color, texture));
        } else {
            System.out.println("Reusing existing TreeType: " + name);
        }
        
        return treeTypes.get(key);
    }

    public static int getTreeTypeCount() {
        return treeTypes.size();
    }

    public static void displayTreeTypes() {
        System.out.println("\nCached Tree Types:");
        for (String key : treeTypes.keySet()) {
            TreeType type = treeTypes.get(key);
            System.out.println("  - " + type.getName() + " (" + type.getColor() + ")");
        }
    }
}
