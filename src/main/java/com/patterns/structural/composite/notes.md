# Composite Pattern

## Overview
The Composite pattern composes objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions uniformly.

## Problem
You have a tree structure where you need to treat leaf nodes (files) and composite nodes (directories) the same way. Without Composite, client code needs type checking and special handling.

## Solution
Define a common interface for both simple and complex objects. Composite objects delegate operations to their children.

## Implementation Details

### Key Components
1. **Component** (`FileSystemComponent`) - Common interface
2. **Leaf** (`File`) - Individual objects with no children
3. **Composite** (`Directory`) - Objects that can contain children

### Example: File System
Both `File` and `Directory` implement `FileSystemComponent`. Clients can call `getSize()` or `showDetails()` on any component without knowing its type.

```java
// Client code - treats all components uniformly
FileSystemComponent component = getComponent();
component.showDetails("");
long size = component.getSize();
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Component Interface                         │
│              (FileSystemComponent)                           │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + showDetails(indent: String)                       │    │
│  │ + getSize(): long                                   │    │
│  │ + getName(): String                                 │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│     Leaf       │                 │   Composite    │
│     (File)     │                 │  (Directory)   │
├────────────────┤                 ├────────────────┤
│ - name         │                 │ - name         │
│ - size         │                 │ - children[]   │
├────────────────┤                 ├────────────────┤
│ showDetails()  │                 │ showDetails()  │
│ getSize()      │                 │   → delegates  │
└────────────────┘                 │ add()          │
                                   │ remove()       │
                                   └────────────────┘
```

## Tree Structure Example
```
root/
├── work/
│   ├── config.json (256)
│   ├── documents/
│   │   ├── document.txt (1024)
│   │   └── notes.md (512)
│   └── media/
│       ├── image.png (2048)
│       └── video.mp4 (50000)
└── readme.txt (128)
```

## Pros
- ✅ Simplifies client code - no type checking needed
- ✅ Open/Closed Principle - Easy to add new component types
- ✅ Represents part-whole hierarchies naturally
- ✅ Recursive operations are straightforward

## Cons
- ❌ May violate Single Responsibility (composite has child management)
- ❌ Can make design overly general
- ❌ Some methods may not make sense for leaves (e.g., add/remove)

## When to Use
- When you have part-whole hierarchies
- When you want clients to treat objects uniformly
- When you need recursive tree operations
- When the tree structure can have arbitrary depth

## Safe vs Unsafe Composite

### Safe Composite (Used here)
- Component interface only has common methods
- add/remove only in Composite class
- Type-safe but less transparent

### Unsafe Composite
- add/remove in Component interface
- Leaves throw UnsupportedOperationException
- More transparent but runtime errors possible

## Related Patterns
- **Decorator**: Both use recursive composition, Decorator adds responsibilities
- **Iterator**: Can be used to traverse composite structures
- **Visitor**: Can perform operations across composite structure
- **Flyweight**: Can share leaf nodes in composite

## Real-World Examples
- GUI component trees (Swing, JavaFX)
- XML/HTML DOM trees
- Organization charts
- Menu systems
