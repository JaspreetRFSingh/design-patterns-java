package com.patterns.principles.solid.lsp;

/** Eagle is a Bird AND it can fly — both contracts honoured. */
public class Eagle extends Bird implements Flyable {

    public Eagle() { super("Eagle"); }

    @Override
    public void fly() {
        System.out.println(name + " soars high in the sky!");
    }

    @Override
    public String describe() {
        return name + " — a powerful flying bird of prey";
    }
}
