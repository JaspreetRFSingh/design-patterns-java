package com.patterns.behavioral.templatemethod;

/**
 * Demo class for Template Method Pattern
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== Template Method Pattern Demo ===\n");

        System.out.println("--- Parsing CSV File ---");
        DataParser csvParser = new CSVParser();
        csvParser.parseData("data.csv");

        System.out.println("--- Parsing JSON File ---");
        DataParser jsonParser = new JSONParser();
        jsonParser.parseData("data.json");

        System.out.println("--- Parsing XML File ---");
        DataParser xmlParser = new XMLParser();
        xmlParser.parseData("data.xml");
    }
}
