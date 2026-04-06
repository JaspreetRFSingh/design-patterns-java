package com.patterns.principles.solid.dip;

/**
 * VIOLATION of Dependency Inversion Principle.
 * High-level module (report generation) directly depends on a low-level module (PDFFormatterViolation).
 * Changing the formatter requires modifying this class.
 */
public class ReportGeneratorViolation {

    // Directly depends on a concrete low-level class
    private final PDFFormatterViolation formatter = new PDFFormatterViolation();

    public void generate(String data) {
        System.out.println("Generating report...");
        String result = formatter.format(data); // tightly coupled
        System.out.println(result);
    }
}
