package com.patterns.creational.factory;

/**
 * Concrete Creator - Word Processing Application
 */
public class WordApplication extends Application {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
