package com.patterns.creational.singleton;

/**
 * Demo class for Singleton Pattern
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===\n");

        // Both references point to the same instance
        ConfigManager config1 = ConfigManager.getInstance();
        ConfigManager config2 = ConfigManager.getInstance();

        System.out.println("Config 1: " + config1);
        System.out.println("Config 2: " + config2);
        System.out.println("Same instance? " + (config1 == config2));

        // Modifying through one reference affects the other
        config1.setConfigData("Updated Configuration");
        System.out.println("\nAfter updating config1:");
        System.out.println("Config 2 now sees: " + config2.getConfigData());
    }
}
