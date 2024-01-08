package com.patterns.creational.factory;

/**
 * Concrete Creator - Spreadsheet Application
 */
public class SpreadsheetApplication extends Application {
    @Override
    public Document createDocument() {
        return new SpreadsheetDocument();
    }
}
