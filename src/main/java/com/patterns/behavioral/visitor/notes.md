# Visitor Pattern

## Overview
The Visitor pattern separates algorithms from the objects on which they operate. It allows adding new operations without modifying the element classes.

## Problem
You need to perform various operations on a complex object structure (like a file system). Adding new operations requires modifying all element classes, violating Open/Closed Principle.

## Solution
Move operations to visitor classes. Elements accept visitors and call the appropriate visit method. New operations are added by creating new visitors.

## Implementation Details

### Key Components
1. **Visitor Interface** (`Visitor`) - Declares visit methods for each element type
2. **Concrete Visitors** (`SizeCalculator`, `FileLister`, `XMLExporter`) - Implement operations
3. **Element Interface** (`FileSystemElement`) - Declares accept method
4. **Concrete Elements** (`File`, `Directory`, `Link`) - Implement accept

### Example: File System Operations
Different operations (size calculation, file listing, XML export) are implemented as separate visitors. The file system elements remain unchanged.

```java
// Usage
Visitor visitor = new SizeCalculator();
fileSystemElement.accept(visitor);
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Visitor Interface                          │
│                     (Visitor)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + visit(File)                                       │    │
│  │ + visit(Directory)                                  │    │
│  │ + visit(Link)                                       │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │   Size  │      │   File    │     │   XML   │
   │Calculator│     │  Lister   │     │ Exporter│
   └─────────┘      └───────────┘     └─────────┘
                          ▲
                          │ uses
┌─────────────────────────┴─────────────────────────┐
│                Element Interface                   │
│              (FileSystemElement)                   │
│  ┌─────────────────────────────────────────────┐  │
│  │ + accept(Visitor)                           │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │   File  │      │ Directory │     │   Link  │
   └─────────┘      └───────────┘     └─────────┘
```

## Double Dispatch
```
1. Client calls: element.accept(visitor)
2. Element calls: visitor.visit(this)  // 'this' determines which visit() is called
3. Visitor executes operation for that element type
```

## Pros
- ✅ Open/Closed Principle - Add operations without changing elements
- ✅ Single Responsibility Principle - Operations in separate classes
- ✅ Easy to add new operations
- ✅ Visitors can accumulate state

## Cons
- ❌ Hard to add new element types (must update all visitors)
- ❌ Breaks encapsulation (visitors need element internals)
- ❌ More classes and interfaces

## When to Use
- When you have stable element classes but need new operations
- When operations need to accumulate state across elements
- For complex object structures (AST, DOM)
- When you need to separate algorithms from data

## Visitor vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Visitor | Add operations to elements |
| Strategy | Interchangeable algorithms |
| Composite | Part-whole hierarchies |
| Command | Encapsulate requests |

## Related Patterns
- **Composite**: Often used together
- **Iterator**: Can traverse elements for visitor
- **Interpreter**: Uses visitor for AST operations

## Real-World Examples
- Compiler AST processing
- XML/HTML DOM manipulation
- Code analysis tools
- Report generation
- Data serialization
