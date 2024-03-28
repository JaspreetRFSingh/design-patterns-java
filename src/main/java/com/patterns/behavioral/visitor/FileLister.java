package com.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Visitor - Lists all files with specific extension
 */
public class FileLister implements Visitor {
    private String extension;
    private List<String> matchingFiles = new ArrayList<>();

    public FileLister(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            System.out.println("Found: " + file.getName());
            matchingFiles.add(file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        System.out.println("Scanning directory: " + directory.getName());
    }

    @Override
    public void visit(Link link) {
        // Skip links
    }

    public List<String> getMatchingFiles() {
        return matchingFiles;
    }
}
