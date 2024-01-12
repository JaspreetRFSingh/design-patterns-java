package com.patterns.creational.abstractfactory;

/**
 * Concrete Product - Mac Button
 */
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Mac-style button with rounded corners");
    }

    @Override
    public void onClick() {
        System.out.println("Mac button clicked");
    }
}
