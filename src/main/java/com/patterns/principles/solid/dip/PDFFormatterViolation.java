package com.patterns.principles.solid.dip;

/** Low-level module — used directly (violation) in ReportGeneratorViolation. */
public class PDFFormatterViolation {
    public String format(String data) {
        return "[PDF] " + data;
    }
}
