package com.patterns.principles.solid.lsp;

/** Sparrow is a Bird that can also fly. */
public class Sparrow extends Bird implements Flyable {

    public Sparrow() { super("Sparrow"); }

    @Override
    public void fly() {
        System.out.println(name + " flutters through the garden!");
    }

    @Override
    public String describe() {
        return name + " — a small, common flying bird";
    }
}
