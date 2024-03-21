package com.patterns.behavioral.state;

/**
 * Context - Vending machine that changes state
 */
public class VendingMachine {
    private State currentState;
    private int count = 0;

    // Concrete states
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;

    public VendingMachine(int initialCount) {
        this.count = initialCount;
        
        // Initialize states
        noQuarterState = new NoQuarterState();
        hasQuarterState = new HasQuarterState();
        soldState = new SoldState();
        soldOutState = new SoldOutState();

        // Set initial state
        currentState = (count > 0) ? noQuarterState : soldOutState;
        System.out.println("Vending machine initialized with " + count + " items\n");
    }

    public void setState(State state) {
        this.currentState = state;
        System.out.println("State changed to: " + state.getStateName());
    }

    public void insertDollar() {
        currentState.insertDollar(this);
    }

    public void ejectMoney() {
        currentState.ejectMoney(this);
    }

    public void dispense() {
        currentState.dispense(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }

    public void releaseBall() {
        if (count > 0) {
            count--;
            System.out.println("Ball dispensed! Remaining: " + count);
        }
    }
}
