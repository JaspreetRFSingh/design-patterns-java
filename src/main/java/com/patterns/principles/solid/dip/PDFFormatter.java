package com.patterns.principles.solid.dip;

/** Low-level detail — implements the abstraction, not called directly by high-level code. */
public class PDFFormatter implements ReportFormatter {

    @Override
    public String format(String data) {
        return "[PDF] " + data + " (pages, fonts, layout applied)";
    }

    @Override
    public String formatName() { return "PDF"; }
}
