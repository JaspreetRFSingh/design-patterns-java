package com.patterns.creational.abstractfactory;

/**
 * Abstract Factory - Creates families of related UI components
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
