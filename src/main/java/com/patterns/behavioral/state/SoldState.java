package com.patterns.behavioral.state;

/**
 * Concrete State - Product being dispensed
 */
public class SoldState implements State {
    @Override
    public void insertDollar(VendingMachine context) {
        System.out.println("Please wait, already dispensing");
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("Cannot return money - product already dispensing");
    }

    @Override
    public void dispense(VendingMachine context) {
        context.releaseBall();
        if (context.getCount() > 0) {
            context.setState(context.getNoQuarterState());
        } else {
            context.setState(context.getSoldOutState());
        }
    }

    @Override
    public String getStateName() {
        return "SoldState";
    }
}
