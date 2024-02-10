package com.patterns.structural.decorator;

/**
 * Concrete Decorator - Adds espresso shot to coffee
 */
public class EspressoDecorator extends CoffeeDecorator {
    public EspressoDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Espresso Shot";
    }
}
