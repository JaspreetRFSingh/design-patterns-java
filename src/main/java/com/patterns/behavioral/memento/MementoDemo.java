package com.patterns.behavioral.memento;

/**
 * Demo class for Memento Pattern
 */
public class MementoDemo {
    public static void main(String[] args) {
        System.out.println("=== Memento Pattern Demo ===\n");

        TextEditor editor = new TextEditor();
        History history = new History();

        // Initial state
        history.save(editor.save());

        // Edit document
        System.out.println("--- Editing Document ---");
        editor.type("Hello");
        history.save(editor.save());
        editor.type(" World");
        history.save(editor.save());
        editor.display();

        // Undo operations
        System.out.println("\n--- Undo Operations ---");
        while (history.canUndo()) {
            EditorMemento memento = history.undo();
            if (memento != null) {
                editor.restore(memento);
                editor.display();
            }
        }

        // Redo operations
        System.out.println("\n--- Redo Operations ---");
        while (history.canRedo()) {
            EditorMemento memento = history.redo();
            if (memento != null) {
                editor.restore(memento);
                editor.display();
            }
        }

        // More editing with backspace
        System.out.println("\n--- More Editing ---");
        editor.type("!");
        history.save(editor.save());
        editor.backspace();
        history.save(editor.save());
        editor.display();

        // Final undo
        System.out.println("\n--- Final Undo ---");
        EditorMemento memento = history.undo();
        if (memento != null) {
            editor.restore(memento);
            editor.display();
        }
    }
}
