# Factory Method Pattern

## Overview
The Factory Method pattern defines an interface for creating objects but lets subclasses decide which class to instantiate. It defers instantiation to subclasses.

## Problem
A framework needs to create different types of objects, but it shouldn't be coupled to concrete classes. The framework should allow extension without modification.

## Solution
Define a factory method in an abstract class that subclasses override to create specific product types.

## Implementation Details

### Key Components
1. **Product** (`Document`) - Common interface for all products
2. **Concrete Products** (`WordDocument`, `PdfDocument`, `SpreadsheetDocument`)
3. **Creator** (`Application`) - Declares the factory method
4. **Concrete Creators** (`WordApplication`, `PdfApplication`, `SpreadsheetApplication`)

### Example: Document Editor
The `Application` class defines `createDocument()` as an abstract method. Each subclass decides what type of document to create.

```java
// Usage
Application app = new WordApplication();
app.newDocument(); // Creates WordDocument
```

## Structure
```
         ┌─────────────┐
         │   Product   │
         │  (Document) │
         └──────┬──────┘
                │
    ┌───────────┼───────────┐
    │           │           │
┌───▼───┐  ┌────▼────┐  ┌───▼────┐
│ Word  │  │   PDF   │  │Spread- │
│Document│  │Document │  │  sheet │
└───────┘  └─────────┘  └────────┘

         ┌─────────────┐
         │   Creator   │
         │(Application)│
         └──────┬──────┘
                │
    ┌───────────┼───────────┐
    │           │           │
┌───▼───┐  ┌────▼────┐  ┌───▼────┐
│  Word │  │   PDF   │  │Spread- │
│  App  │  │   App   │  │  sheet │
└───────┘  └─────────┘  └────────┘
```

## Pros
- ✅ Single Responsibility Principle - Product creation code in one place
- ✅ Open/Closed Principle - Add new products without changing existing code
- ✅ Decouples client code from concrete classes
- ✅ Allows loose coupling between creator and products

## Cons
- ❌ Increased number of classes
- ❌ Can lead to many small classes
- ❌ More complex than simple instantiation

## When to Use
- When you don't know beforehand the exact types your code should work with
- When you want to provide a library of products and allow users to extend it
- When you want to save system resources by reusing existing objects

## Factory Method vs Abstract Factory
| Factory Method | Abstract Factory |
|---------------|------------------|
| Creates one product | Creates families of products |
| Uses inheritance | Uses composition |
| One method to override | Multiple methods to override |

## Related Patterns
- **Abstract Factory**: Often implemented using Factory Methods
- **Template Method**: Factory Method is often called within template methods
- **Prototype**: Alternative to Factory Method when creation is expensive
