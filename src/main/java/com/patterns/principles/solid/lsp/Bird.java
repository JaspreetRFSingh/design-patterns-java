package com.patterns.principles.solid.lsp;

/**
 * Liskov Substitution Principle — correct implementation.
 * Bird captures only what ALL birds share. No fly() here.
 */
public abstract class Bird {

    protected final String name;

    public Bird(String name) { this.name = name; }

    public String getName() { return name; }

    public abstract String describe();
}
