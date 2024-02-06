package com.patterns.structural.composite;

/**
 * Demo class for Composite Pattern
 */
public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Demo ===\n");

        // Create files
        File file1 = new File("document.txt", 1024);
        File file2 = new File("image.png", 2048);
        File file3 = new File("video.mp4", 50000);
        File file4 = new File("notes.md", 512);
        File file5 = new File("config.json", 256);

        // Create directories
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory media = new Directory("media");
        Directory work = new Directory("work");

        // Build tree structure
        documents.add(file1);
        documents.add(file4);
        
        media.add(file2);
        media.add(file3);
        
        work.add(file5);
        work.add(documents);
        work.add(media);

        root.add(work);
        root.add(new File("readme.txt", 128));

        // Display structure
        System.out.println("File System Structure:");
        root.showDetails("");

        System.out.println("\nTotal size of root: " + root.getSize() + " bytes");
        System.out.println("Size of documents: " + documents.getSize() + " bytes");
        System.out.println("Size of media: " + media.getSize() + " bytes");
    }
}
