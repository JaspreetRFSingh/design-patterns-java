package com.patterns.behavioral.memento;

/**
 * Memento - Stores internal state of Originator
 */
public class EditorMemento {
    // Immutable state snapshot
    private final String content;
    private final int cursorPosition;

    public EditorMemento(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}
