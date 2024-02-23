package com.patterns.structural.proxy;

/**
 * Real Subject - Actual image that loads from disk
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + fileName);
        // Simulate expensive operation
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image loaded successfully!");
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
