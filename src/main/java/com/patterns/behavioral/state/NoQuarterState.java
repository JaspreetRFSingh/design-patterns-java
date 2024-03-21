package com.patterns.behavioral.state;

/**
 * Concrete State - No money inserted
 */
public class NoQuarterState implements State {
    @Override
    public void insertDollar(VendingMachine context) {
        System.out.println("Dollar inserted");
        context.setState(context.getHasQuarterState());
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("No money to return");
    }

    @Override
    public void dispense(VendingMachine context) {
        System.out.println("Please insert a dollar first");
    }

    @Override
    public String getStateName() {
        return "NoQuarterState";
    }
}
