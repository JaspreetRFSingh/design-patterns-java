package com.patterns.creational.factory;

/**
 * Creator - Abstract factory method
 */
public abstract class Application {
    
    /**
     * Factory method - to be implemented by subclasses
     */
    public abstract Document createDocument();

    /**
     * Template method using the factory method
     */
    public void newDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }

    public void openDocument(Document doc) {
        doc.open();
    }
}
