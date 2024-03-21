package com.patterns.behavioral.state;

/**
 * Demo class for State Pattern
 */
public class StateDemo {
    public static void main(String[] args) {
        System.out.println("=== State Pattern Demo ===\n");

        VendingMachine machine = new VendingMachine(2);

        System.out.println("--- Test 1: Normal purchase ---");
        machine.insertDollar();
        machine.dispense();

        System.out.println("\n--- Test 2: Another purchase ---");
        machine.insertDollar();
        machine.dispense();

        System.out.println("\n--- Test 3: Machine now empty ---");
        machine.insertDollar();
        machine.dispense();

        System.out.println("\n--- Test 4: Eject money ---");
        machine = new VendingMachine(1);
        machine.insertDollar();
        machine.ejectMoney();
        machine.dispense(); // Should fail - no money inserted
    }
}
