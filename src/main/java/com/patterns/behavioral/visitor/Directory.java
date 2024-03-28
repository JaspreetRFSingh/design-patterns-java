package com.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Element - Directory containing other elements
 */
public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }
}
