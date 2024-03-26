package com.patterns.behavioral.templatemethod;

/**
 * Abstract Class - Defines template for data parsing
 */
public abstract class DataParser {
    
    /**
     * Template method - defines the algorithm skeleton
     */
    public final void parseData(String filePath) {
        openFile(filePath);
        extractData();
        parseData();
        closeFile();
        if (shouldSendReport()) {
            sendReport();
        }
    }

    // Common steps - implemented in abstract class
    protected void openFile(String filePath) {
        System.out.println("Opening file: " + filePath);
    }

    protected void closeFile() {
        System.out.println("Closing file\n");
    }

    protected boolean shouldSendReport() {
        return true;
    }

    // Abstract steps - must be implemented by subclasses
    protected abstract void extractData();
    protected abstract void parseData();
    protected abstract void sendReport();
}
