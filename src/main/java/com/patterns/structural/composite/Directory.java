package com.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite - Directory that can contain files and other directories
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    public FileSystemComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📁 " + name);
        for (FileSystemComponent component : children) {
            component.showDetails(indent + "  ");
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public String getName() {
        return name;
    }
}
