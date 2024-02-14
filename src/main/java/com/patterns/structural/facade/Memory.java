package com.patterns.structural.facade;

/**
 * Subsystem - Memory component
 */
public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory: Loading data at position " + position);
    }

    public void free() {
        System.out.println("Memory: Freeing memory...");
    }
}
