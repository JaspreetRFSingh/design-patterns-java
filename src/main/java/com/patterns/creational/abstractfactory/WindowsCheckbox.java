package com.patterns.creational.abstractfactory;

/**
 * Concrete Product - Windows Checkbox
 */
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering Windows-style checkbox");
    }

    @Override
    public void toggle() {
        System.out.println("Windows checkbox toggled");
    }
}
