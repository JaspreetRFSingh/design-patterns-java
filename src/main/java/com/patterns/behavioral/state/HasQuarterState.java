package com.patterns.behavioral.state;

/**
 * Concrete State - Money inserted, waiting for dispense
 */
public class HasQuarterState implements State {
    @Override
    public void insertDollar(VendingMachine context) {
        System.out.println("Already have a dollar");
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("Dollar returned");
        context.setState(context.getNoQuarterState());
    }

    @Override
    public void dispense(VendingMachine context) {
        System.out.println("Dispensing product...");
        context.setState(context.getSoldState());
    }

    @Override
    public String getStateName() {
        return "HasQuarterState";
    }
}
