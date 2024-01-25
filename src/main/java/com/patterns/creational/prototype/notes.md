# Prototype Pattern

## Overview
The Prototype pattern creates new objects by copying an existing object (prototype) rather than creating from scratch.

## Problem
Creating new objects is expensive when:
- Object initialization requires significant resources
- Object creation involves complex database operations
- Object has many default values that need setup

## Solution
Store pre-initialized prototype objects and clone them when needed.

## Implementation Details

### Key Components
1. **Prototype Interface** (`Shape`) - Declares cloning method
2. **Concrete Prototypes** (`Circle`, `Rectangle`) - Implement cloning
3. **Prototype Registry** (`ShapeRegistry`) - Manages prototype instances

### Example: Shape Drawing System
The `ShapeRegistry` maintains pre-configured shape prototypes. When a new shape is needed, it clones the prototype and modifies only the necessary properties.

```java
// Usage
ShapeRegistry registry = new ShapeRegistry();
Shape circle = registry.getShape("Circle"); // Returns a clone
circle.draw();
```

## Deep vs Shallow Copy

### Shallow Copy
```java
@Override
public Shape clone() {
    try {
        return (Shape) super.clone();
    } catch (CloneNotSupportedException e) {
        return null;
    }
}
```
- Copies primitive fields
- References point to same objects

### Deep Copy (Used in this example)
```java
public Circle(Circle other) {
    this.x = other.x;
    this.y = other.y;
    this.radius = other.radius;
    this.color = other.color;
}
```
- Creates new copies of referenced objects
- Completely independent clone

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Prototype Interface                        │
│                       (Shape)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + clone(): Shape                                    │    │
│  │ + draw(): void                                      │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│    Circle      │                 │   Rectangle    │
│                │                 │                │
│ + clone()      │                 │ + clone()      │
└────────────────┘                 └────────────────┘
                          ▲
                          │
┌─────────────────────────┴─────────────────────────┐
│                  ShapeRegistry                     │
│  ┌─────────────────────────────────────────────┐  │
│  │ - shapeCache: Map<String, Shape>            │  │
│  │ + getShape(type): Shape                     │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
```

## Pros
- ✅ Reduces object creation overhead
- ✅ Avoids expensive initialization
- ✅ Produces objects independent of concrete classes
- ✅ Can add/remove prototypes at runtime

## Cons
- ❌ Cloning complex objects with circular references is tricky
- ❌ Deep copy can be as expensive as construction
- ❌ Requires careful implementation of clone method

## When to Use
- When object creation is more expensive than cloning
- When you need to avoid building a class hierarchy of factories
- When objects have many possible states and you want to store them
- When working with objects that have mutable state

## Prototype vs Factory
| Aspect | Prototype | Factory |
|--------|-----------|---------|
| Creation | Clone existing | Create new |
| Performance | Faster for complex objects | May be slower |
| Flexibility | Runtime configuration | Compile-time |

## Related Patterns
- **Abstract Factory**: Can use Prototype for product creation
- **Composite**: Prototypes can be used to create complex structures
- **Memento**: Both involve storing/restoring state
- **Decorator**: Cloning can preserve decorations
