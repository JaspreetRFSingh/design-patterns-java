package com.patterns.structural.flyweight;

/**
 * Concrete Flyweight - Shared tree type with intrinsic state
 */
public class TreeType implements Tree {
    // Intrinsic state (shared, immutable)
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Drawing " + name + " tree (" + color + ") at (" + x + ", " + y + ")");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }
}
