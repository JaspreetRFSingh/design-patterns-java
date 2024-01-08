package com.patterns.creational.factory;

/**
 * Product interface - defines the common interface for all products
 */
public interface Document {
    void open();
    void close();
    void save();
}
