package com.patterns.structural.flyweight;

/**
 * Context - Tree object with extrinsic state
 */
public class TreeObject {
    // Extrinsic state (unique per object)
    private int x;
    private int y;
    private TreeType treeType;

    public TreeObject(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void display() {
        treeType.display(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
