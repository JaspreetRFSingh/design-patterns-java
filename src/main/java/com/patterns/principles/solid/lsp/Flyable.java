package com.patterns.principles.solid.lsp;

/**
 * Capability interface — only birds that actually fly implement this.
 * Separating the capability from the type hierarchy respects LSP.
 */
public interface Flyable {
    void fly();
}
