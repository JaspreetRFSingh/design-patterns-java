package com.patterns.behavioral.visitor;

/**
 * Element Interface - Accepts visitors
 */
public interface FileSystemElement {
    void accept(Visitor visitor);
    String getName();
}
