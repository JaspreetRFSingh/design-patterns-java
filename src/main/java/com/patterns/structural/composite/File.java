package com.patterns.structural.composite;

/**
 * Leaf - Individual file in the file system
 */
public class File implements FileSystemComponent {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + " bytes)");
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }
}
