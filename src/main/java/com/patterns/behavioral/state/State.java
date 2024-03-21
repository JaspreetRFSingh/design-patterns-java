package com.patterns.behavioral.state;

/**
 * State Interface - Defines behavior for each state
 */
public interface State {
    void insertDollar(VendingMachine context);
    void ejectMoney(VendingMachine context);
    void dispense(VendingMachine context);
    String getStateName();
}
