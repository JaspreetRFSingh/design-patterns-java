package com.patterns.creational.factory;

/**
 * Concrete Product - PDF Document
 */
public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document with fixed layout...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving as .pdf file...");
    }
}
