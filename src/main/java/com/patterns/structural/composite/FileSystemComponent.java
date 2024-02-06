package com.patterns.structural.composite;

/**
 * Component Interface - Common interface for all elements
 */
public interface FileSystemComponent {
    void showDetails(String indent);
    long getSize();
    String getName();
}
