package com.patterns.behavioral.state;

/**
 * Concrete State - Machine is out of products
 */
public class SoldOutState implements State {
    @Override
    public void insertDollar(VendingMachine context) {
        System.out.println("Machine is sold out - returning dollar");
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("No money to return");
    }

    @Override
    public void dispense(VendingMachine context) {
        System.out.println("Machine is sold out");
    }

    @Override
    public String getStateName() {
        return "SoldOutState";
    }
}
