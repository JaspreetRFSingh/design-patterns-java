package com.patterns.behavioral.memento;

import java.util.Stack;

/**
 * Caretaker - Manages mementos without examining them
 */
public class History {
    private Stack<EditorMemento> undoStack = new Stack<>();
    private Stack<EditorMemento> redoStack = new Stack<>();

    public void save(EditorMemento memento) {
        undoStack.push(memento);
        redoStack.clear(); // Clear redo on new action
    }

    public EditorMemento undo() {
        if (!undoStack.isEmpty()) {
            EditorMemento memento = undoStack.pop();
            redoStack.push(memento);
            return undoStack.isEmpty() ? null : undoStack.peek();
        }
        return null;
    }

    public EditorMemento redo() {
        if (!redoStack.isEmpty()) {
            EditorMemento memento = redoStack.pop();
            undoStack.push(memento);
            return memento;
        }
        return null;
    }

    public boolean canUndo() {
        return undoStack.size() > 1; // At least initial state + one change
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
