# Memento Pattern

## Overview
The Memento pattern captures and externalizes an object's internal state without violating encapsulation, so the object can be restored to this state later.

## Problem
You need to implement undo/redo functionality. Directly accessing an object's internal state would break encapsulation.

## Solution
Create a memento object that stores the state. The originator creates mementos and uses them to restore state. A caretaker manages mementos without accessing their contents.

## Implementation Details

### Key Components
1. **Memento** (`EditorMemento`) - Stores state snapshot
2. **Originator** (`TextEditor`) - Creates and uses mementos
3. **Caretaker** (`History`) - Manages mementos

### Example: Text Editor with Undo/Redo
The `TextEditor` creates mementos before each operation. The `History` caretaker stores these mementos in stacks for undo/redo functionality.

```java
// Usage
history.save(editor.save());  // Save state
editor.type("Hello");
editor.restore(history.undo()); // Undo to previous state
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                     Memento                                  │
│                (EditorMemento)                               │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - content: String                                   │    │
│  │ - cursorPosition: int                               │    │
│  │ + getContent()                                      │    │
│  │ + getCursorPosition()                               │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ creates/restores
┌─────────────────────────┴─────────────────────────┐
│                   Originator                       │
│                 (TextEditor)                       │
│  ┌─────────────────────────────────────────────┐  │
│  │ - content: String                           │  │
│  │ - cursorPosition: int                       │  │
│  │ + save(): Memento                           │  │
│  │ + restore(Memento)                          │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
                          │ stores/retrieves
┌─────────────────────────┴─────────────────────────┐
│                    Caretaker                       │
│                   (History)                        │
│  ┌─────────────────────────────────────────────┐  │
│  │ - undoStack: Stack<Memento>                 │  │
│  │ - redoStack: Stack<Memento>                 │  │
│  │ + save(Memento)                             │  │
│  │ + undo(): Memento                           │  │
│  │ + redo(): Memento                           │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
```

## Encapsulation Preservation
```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│  Caretaker  │     │  Originator │     │   Memento   │
│  (History)  │     │ (TextEditor)│     │(EditorMemento)│
└──────┬──────┘     └──────┬──────┘     └──────┬──────┘
       │                   │                   │
       │ Stores Memento    │ Creates Memento   │ Holds state
       │ (opaque)          │ (has access)      │ (private)
       │                   │                   │
       └──────────────────→│                   │
                           │ ←─────────────────┘
                           │ Reads state
```

## Pros
- ✅ Preserves encapsulation
- ✅ Simplifies originator code
- ✅ Easy undo/redo implementation
- ✅ Can create checkpoints

## Cons
- ❌ Can consume lots of memory
- ❌ Caretaker needs to manage lifecycle
- ❌ May require deep copies
- ❌ Expensive for large state

## When to Use
- When you need undo/redo functionality
- When you need to save checkpoints
- When direct state access would break encapsulation
- For snapshot functionality

## Related Patterns
- **Command**: Can use memento for undo
- **Iterator**: Can use memento for state
- **Prototype**: For cloning mementos
- **State**: Can use memento for state transitions

## Real-World Examples
- Text editor undo/redo
- Game save states
- Database transactions
- Version control systems
- Browser history
