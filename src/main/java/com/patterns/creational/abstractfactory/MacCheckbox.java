package com.patterns.creational.abstractfactory;

/**
 * Concrete Product - Mac Checkbox
 */
public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering Mac-style checkbox");
    }

    @Override
    public void toggle() {
        System.out.println("Mac checkbox toggled");
    }
}
