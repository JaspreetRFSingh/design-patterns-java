package com.patterns.principles.solid.lsp;

/**
 * Penguin is a Bird but does NOT implement Flyable — honest about its capabilities.
 * Can be substituted wherever a Bird is expected without surprising the caller.
 */
public class Penguin extends Bird {

    public Penguin() { super("Penguin"); }

    public void swim() {
        System.out.println(name + " swims gracefully through icy water!");
    }

    @Override
    public String describe() {
        return name + " — a flightless bird that swims";
    }
}
