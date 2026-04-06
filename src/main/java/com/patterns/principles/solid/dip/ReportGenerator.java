package com.patterns.principles.solid.dip;

/**
 * High-level module — depends only on the ReportFormatter abstraction.
 * Does not know or care which concrete formatter is used.
 * The dependency is injected (constructor injection).
 */
public class ReportGenerator {

    private final ReportFormatter formatter;

    public ReportGenerator(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public void generate(String data) {
        System.out.println("Generating " + formatter.formatName() + " report...");
        System.out.println(formatter.format(data));
    }
}
