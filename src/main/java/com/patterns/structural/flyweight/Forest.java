package com.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Forest - Manages collection of trees
 */
public class Forest {
    private List<TreeObject> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        trees.add(new TreeObject(x, y, type));
    }

    public void drawForest() {
        for (TreeObject tree : trees) {
            tree.display();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}
