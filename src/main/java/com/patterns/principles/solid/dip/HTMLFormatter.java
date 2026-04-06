package com.patterns.principles.solid.dip;

/** New formatter added without touching ReportGenerator — DIP in action. */
public class HTMLFormatter implements ReportFormatter {

    @Override
    public String format(String data) {
        return "<html><body><p>" + data + "</p></body></html>";
    }

    @Override
    public String formatName() { return "HTML"; }
}
