package com.patterns.structural.decorator;

/**
 * Concrete Decorator - Adds whipped cream to coffee
 */
public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Whipped Cream";
    }
}
