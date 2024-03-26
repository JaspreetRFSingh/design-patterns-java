package com.patterns.behavioral.templatemethod;

/**
 * Concrete Class - Parses XML files
 */
public class XMLParser extends DataParser {
    @Override
    protected void extractData() {
        System.out.println("Extracting XML data (eXtensible Markup Language)");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing XML tags and attributes");
        System.out.println("Building DOM tree");
    }

    @Override
    protected void sendReport() {
        System.out.println("Sending XML parsing report via FTP");
    }

    @Override
    protected boolean shouldSendReport() {
        System.out.println("XML parsing requires mandatory reporting");
        return true;
    }
}
