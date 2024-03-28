package com.patterns.behavioral.visitor;

/**
 * Concrete Visitor - Calculates total size of file system
 */
public class SizeCalculator implements Visitor {
    private long totalSize = 0;

    @Override
    public void visit(File file) {
        System.out.println("File: " + file.getName() + " (" + file.getSize() + " bytes)");
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        System.out.println("Directory: " + directory.getName());
    }

    @Override
    public void visit(Link link) {
        System.out.println("Link: " + link.getName() + " → " + link.getTargetPath() + " (0 bytes)");
        // Links don't add to size
    }

    public long getTotalSize() {
        return totalSize;
    }
}
