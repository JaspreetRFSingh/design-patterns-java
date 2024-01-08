package com.patterns.creational.factory;

/**
 * Concrete Creator - PDF Application
 */
public class PdfApplication extends Application {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
