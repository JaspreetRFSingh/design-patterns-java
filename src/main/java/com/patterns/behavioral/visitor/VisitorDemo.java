package com.patterns.behavioral.visitor;

/**
 * Demo class for Visitor Pattern
 */
public class VisitorDemo {
    public static void main(String[] args) {
        System.out.println("=== Visitor Pattern Demo ===\n");

        // Build file system structure
        Directory root = new Directory("root");
        
        Directory src = new Directory("src");
        src.addElement(new File("Main.java", 2048));
        src.addElement(new File("Utils.java", 1024));
        
        Directory test = new Directory("test");
        test.addElement(new File("MainTest.java", 1536));
        
        Directory docs = new Directory("docs");
        docs.addElement(new File("README.md", 512));
        docs.addElement(new Link("api-docs", "/external/api"));
        
        root.addElement(src);
        root.addElement(test);
        root.addElement(docs);
        root.addElement(new File("pom.xml", 2048));
        root.addElement(new Link("config", "/etc/config"));

        // Use SizeCalculator visitor
        System.out.println("--- Size Calculator ---");
        SizeCalculator sizeCalc = new SizeCalculator();
        root.accept(sizeCalc);
        System.out.println("\nTotal size: " + sizeCalc.getTotalSize() + " bytes\n");

        // Use FileLister visitor
        System.out.println("--- Java File Lister ---");
        FileLister javaLister = new FileLister(".java");
        root.accept(javaLister);
        System.out.println("\nFound " + javaLister.getMatchingFiles().size() + " Java files\n");

        // Use XMLExporter visitor
        System.out.println("--- XML Export ---");
        XMLExporter exporter = new XMLExporter();
        root.accept(exporter);
        System.out.println("\nGenerated XML:");
        System.out.println(exporter.getXML());
    }
}
