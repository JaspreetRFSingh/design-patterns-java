package com.patterns.creational.abstractfactory;

/**
 * Client code that uses the abstract factory
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public void interact() {
        button.onClick();
        checkbox.toggle();
    }
}
