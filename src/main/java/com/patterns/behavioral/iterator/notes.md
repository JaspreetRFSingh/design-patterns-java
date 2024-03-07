# Iterator Pattern

## Overview
The Iterator pattern provides a way to access elements of a collection sequentially without exposing its underlying representation.

## Problem
Collections have different internal structures (arrays, lists, trees, graphs). Client code shouldn't depend on these implementations and should have a uniform way to traverse elements.

## Solution
Provide an iterator object that encapsulates traversal logic. The collection creates the appropriate iterator, and clients use a standard interface.

## Implementation Details

### Key Components
1. **Iterator Interface** (`BookIterator`) - Defines traversal methods
2. **Aggregate Interface** (`BookCollection`) - Creates iterators
3. **Concrete Iterator** (`LibraryIterator`) - Implements traversal
4. **Concrete Aggregate** (`Library`) - Creates specific iterator

### Example: Library Book Collection
The `Library` maintains a list of books and provides an iterator. Clients can traverse forward, backward, or reset without knowing the internal structure.

```java
// Usage
BookIterator iterator = library.createIterator();
while (iterator.hasNext()) {
    Book book = iterator.next();
    System.out.println(book);
}
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Iterator Interface                         │
│                  (BookIterator)                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + hasNext(): boolean                                │    │
│  │ + next(): Book                                      │    │
│  │ + hasPrevious(): boolean                            │    │
│  │ + previous(): Book                                  │    │
│  │ + reset(): void                                     │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│              Concrete Iterator                     │
│            (LibraryIterator)                       │
│  ┌─────────────────────────────────────────────┐  │
│  │ - books: List<Book>                         │  │
│  │ - position: int                             │  │
│  │ + hasNext() / next()                        │  │
│  │ + hasPrevious() / previous()                │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
                          │ creates
┌─────────────────────────┴─────────────────────────┐
│                Aggregate Interface                 │
│                (BookCollection)                    │
│  ┌─────────────────────────────────────────────┐  │
│  │ + createIterator(): BookIterator            │  │
│  │ + addBook(book)                             │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│             Concrete Aggregate                     │
│                 (Library)                          │
│  ┌─────────────────────────────────────────────┐  │
│  │ - books: List<Book>                         │  │
│  │ + createIterator() → LibraryIterator        │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
```

## Pros
- ✅ Single Responsibility Principle - Separate traversal from collection
- ✅ Open/Closed Principle - Add new iterators without changing collection
- ✅ Multiple traversals simultaneously
- ✅ Uniform interface for different collections
- ✅ Can iterate over complex structures (trees, graphs)

## Cons
- ❌ Additional classes and interfaces
- ❌ May be overkill for simple collections
- ❌ Iterator can become invalid if collection changes

## When to Use
- When you need different traversal algorithms
- When you want to hide collection implementation
- When you need multiple simultaneous traversals
- For complex data structures (trees, graphs)

## Iterator Types
- **Forward Iterator**: One-direction traversal
- **Bidirectional Iterator**: Forward and backward
- **Filtering Iterator**: Only certain elements
- **Composite Iterator**: Traverse tree structures

## Related Patterns
- **Composite**: Iterate over tree structures
- **Factory Method**: Create appropriate iterator
- **Memento**: Save iterator state
- **Visitor**: Alternative for operations on collections

## Real-World Examples
- Java `Iterator`, `Iterable` interfaces
- Java `Enumeration` (legacy)
- Python iterators
- Database cursors
- File system traversal
