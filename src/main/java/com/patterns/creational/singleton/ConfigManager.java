package com.patterns.creational.singleton;

/**
 * Singleton Pattern - Ensures a class has only one instance and provides global access point.
 * 
 * Use cases: Configuration managers, Thread pools, Cache, Logging, Database connections
 */
public class ConfigManager {
    private static volatile ConfigManager instance;
    private String configData;

    // Private constructor prevents instantiation from outside
    private ConfigManager() {
        this.configData = "Default Configuration";
    }

    /**
     * Thread-safe lazy initialization using double-checked locking
     */
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }

    @Override
    public String toString() {
        return "ConfigManager{configData='" + configData + "'}";
    }
}
