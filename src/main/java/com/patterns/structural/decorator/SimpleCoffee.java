package com.patterns.structural.decorator;

/**
 * Concrete Component - Basic coffee
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.00;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
