package com.patterns.principles.solid.dip;

/** Another formatter — plugged in without any changes to ReportGenerator. */
public class CSVFormatter implements ReportFormatter {

    @Override
    public String format(String data) {
        return "\"title\",\"content\"\n\"Report\",\"" + data + "\"";
    }

    @Override
    public String formatName() { return "CSV"; }
}
