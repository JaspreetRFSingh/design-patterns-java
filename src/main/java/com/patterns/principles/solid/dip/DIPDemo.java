package com.patterns.principles.solid.dip;

/**
 * Demonstrates the Dependency Inversion Principle (DIP).
 */
public class DIPDemo {

    public static void main(String[] args) {
        System.out.println("=== DIP Violation ===");
        ReportGeneratorViolation bad = new ReportGeneratorViolation();
        bad.generate("Q1 Sales Data");
        System.out.println("(To switch to HTML, you must edit ReportGeneratorViolation)");

        System.out.println();
        System.out.println("=== DIP Correct Implementation ===");
        String data = "Q1 Sales Data";

        // Inject different formatters — ReportGenerator never changes
        ReportGenerator pdfReport = new ReportGenerator(new PDFFormatter());
        pdfReport.generate(data);

        System.out.println();
        ReportGenerator htmlReport = new ReportGenerator(new HTMLFormatter());
        htmlReport.generate(data);

        System.out.println();
        ReportGenerator csvReport = new ReportGenerator(new CSVFormatter());
        csvReport.generate(data);

        System.out.println();
        System.out.println("ReportGenerator was never modified — only the injected formatter changed.");
    }
}
