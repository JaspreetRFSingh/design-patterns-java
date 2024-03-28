package com.patterns.behavioral.visitor;

/**
 * Concrete Visitor - Exports file system structure to XML
 */
public class XMLExporter implements Visitor {
    private StringBuilder xml = new StringBuilder();
    private int indentLevel = 0;

    @Override
    public void visit(File file) {
        xml.append(getIndent())
           .append("<file name=\"").append(file.getName())
           .append("\" size=\"").append(file.getSize())
           .append("\"/>\n");
    }

    @Override
    public void visit(Directory directory) {
        xml.append(getIndent())
           .append("<directory name=\"").append(directory.getName()).append("\">\n");
        indentLevel++;
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
        indentLevel--;
        xml.append(getIndent()).append("</directory>\n");
    }

    @Override
    public void visit(Link link) {
        xml.append(getIndent())
           .append("<link name=\"").append(link.getName())
           .append("\" target=\"").append(link.getTargetPath())
           .append("\"/>\n");
    }

    private String getIndent() {
        return "  ".repeat(indentLevel);
    }

    public String getXML() {
        return xml.toString();
    }
}
