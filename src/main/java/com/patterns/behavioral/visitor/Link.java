package com.patterns.behavioral.visitor;

/**
 * Concrete Element - Symbolic link
 */
public class Link implements FileSystemElement {
    private String name;
    private String targetPath;

    public Link(String name, String targetPath) {
        this.name = name;
        this.targetPath = targetPath;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getTargetPath() {
        return targetPath;
    }
}
