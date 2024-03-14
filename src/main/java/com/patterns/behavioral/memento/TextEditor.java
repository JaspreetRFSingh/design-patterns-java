package com.patterns.behavioral.memento;

/**
 * Originator - Text editor that creates/restores mementos
 */
public class TextEditor {
    private String content = "";
    private int cursorPosition = 0;

    public void type(String text) {
        content = content.substring(0, cursorPosition) + text + content.substring(cursorPosition);
        cursorPosition += text.length();
        System.out.println("Typed: \"" + text + "\"");
    }

    public void moveCursor(int position) {
        cursorPosition = Math.max(0, Math.min(position, content.length()));
        System.out.println("Cursor moved to position " + cursorPosition);
    }

    public void backspace() {
        if (cursorPosition > 0) {
            content = content.substring(0, cursorPosition - 1) + content.substring(cursorPosition);
            cursorPosition--;
            System.out.println("Backspace pressed");
        }
    }

    /**
     * Creates a memento with current state
     */
    public EditorMemento save() {
        System.out.println("Saving state...");
        return new EditorMemento(content, cursorPosition);
    }

    /**
     * Restores state from memento
     */
    public void restore(EditorMemento memento) {
        System.out.println("Restoring state...");
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
    }

    public String getContent() {
        return content;
    }

    public void display() {
        System.out.println("Content: \"" + content + "\" (cursor at " + cursorPosition + ")");
    }
}
