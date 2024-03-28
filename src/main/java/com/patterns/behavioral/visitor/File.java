package com.patterns.behavioral.visitor;

/**
 * Concrete Element - File in the file system
 */
public class File implements FileSystemElement {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
