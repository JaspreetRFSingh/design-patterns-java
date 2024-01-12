package com.patterns.creational.abstractfactory;

/**
 * Concrete Product - Windows Button
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Windows-style button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button clicked");
    }
}
