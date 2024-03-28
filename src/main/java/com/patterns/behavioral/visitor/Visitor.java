package com.patterns.behavioral.visitor;

/**
 * Visitor Interface - Defines operations for each element type
 */
public interface Visitor {
    void visit(File file);
    void visit(Directory directory);
    void visit(Link link);
}
