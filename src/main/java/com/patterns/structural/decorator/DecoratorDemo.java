package com.patterns.structural.decorator;

/**
 * Demo class for Decorator Pattern
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo ===\n");

        // Order 1: Simple coffee with milk and sugar
        Coffee order1 = new SimpleCoffee();
        order1 = new MilkDecorator(order1);
        order1 = new SugarDecorator(order1);
        System.out.println("Order 1: " + order1.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", order1.getCost()));

        System.out.println();

        // Order 2: Fancy coffee with multiple additions
        Coffee order2 = new SimpleCoffee();
        order2 = new EspressoDecorator(order2);
        order2 = new WhippedCreamDecorator(order2);
        order2 = new MilkDecorator(order2);
        order2 = new SugarDecorator(order2);
        System.out.println("Order 2: " + order2.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", order2.getCost()));

        System.out.println();

        // Order 3: Double espresso
        Coffee order3 = new SimpleCoffee();
        order3 = new EspressoDecorator(order3);
        order3 = new EspressoDecorator(order3);
        System.out.println("Order 3: " + order3.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", order3.getCost()));
    }
}
