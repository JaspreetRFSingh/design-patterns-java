package com.patterns.structural.proxy;

/**
 * Proxy - Controls access to RealImage with lazy loading
 */
public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        // Don't load image yet - lazy loading
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("Proxy: Loading image on first display request...");
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
