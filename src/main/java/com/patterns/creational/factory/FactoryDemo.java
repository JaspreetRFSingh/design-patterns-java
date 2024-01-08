package com.patterns.creational.factory;

/**
 * Demo class for Factory Method Pattern
 */
public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");

        // Create different applications
        Application wordApp = new WordApplication();
        Application pdfApp = new PdfApplication();
        Application spreadsheetApp = new SpreadsheetApplication();

        System.out.println("Creating Word document:");
        wordApp.newDocument();

        System.out.println("\nCreating PDF document:");
        pdfApp.newDocument();

        System.out.println("\nCreating Spreadsheet document:");
        spreadsheetApp.newDocument();
    }
}
