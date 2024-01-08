package com.patterns.creational.factory;

/**
 * Concrete Product - Spreadsheet Document
 */
public class SpreadsheetDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet with cells and formulas...");
    }

    @Override
    public void close() {
        System.out.println("Closing Spreadsheet document...");
    }

    @Override
    public void save() {
        System.out.println("Saving as .xlsx file...");
    }
}
