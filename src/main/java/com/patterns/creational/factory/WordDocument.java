package com.patterns.creational.factory;

/**
 * Concrete Product - Word Document
 */
public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document with text formatting...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving as .docx file...");
    }
}
