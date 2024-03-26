package com.patterns.behavioral.templatemethod;

/**
 * Concrete Class - Parses JSON files
 */
public class JSONParser extends DataParser {
    @Override
    protected void extractData() {
        System.out.println("Extracting JSON data (JavaScript Object Notation)");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing JSON structure");
        System.out.println("Mapping to Java objects");
    }

    @Override
    protected void sendReport() {
        System.out.println("Sending JSON parsing report via webhook");
    }
}
