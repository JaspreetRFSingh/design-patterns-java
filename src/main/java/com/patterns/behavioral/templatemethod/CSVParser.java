package com.patterns.behavioral.templatemethod;

/**
 * Concrete Class - Parses CSV files
 */
public class CSVParser extends DataParser {
    @Override
    protected void extractData() {
        System.out.println("Extracting CSV data (comma-separated values)");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing CSV rows and columns");
        System.out.println("Converting to objects");
    }

    @Override
    protected void sendReport() {
        System.out.println("Sending CSV parsing report via email");
    }
}
