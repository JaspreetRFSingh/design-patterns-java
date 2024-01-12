package com.patterns.creational.abstractfactory;

/**
 * Demo class for Abstract Factory Pattern
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");

        // Create Windows UI
        System.out.println("Windows UI:");
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.paint();
        windowsApp.interact();

        System.out.println("\nMac UI:");
        // Create Mac UI
        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.paint();
        macApp.interact();
    }
}
