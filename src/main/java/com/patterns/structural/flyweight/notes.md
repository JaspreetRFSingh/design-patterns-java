# Flyweight Pattern

## Overview
The Flyweight pattern minimizes memory usage by sharing as much data as possible with similar objects. It's useful when a large number of similar objects need to be created.

## Problem
Creating thousands of similar objects consumes too much memory. Many objects have the same intrinsic (shared) state but different extrinsic (unique) state.

## Solution
Separate intrinsic state (shared, immutable) from extrinsic state (unique). Store intrinsic state in flyweight objects and pass extrinsic state when needed.

## Implementation Details

### Key Components
1. **Flyweight Interface** (`Tree`) - Common interface
2. **Concrete Flyweight** (`TreeType`) - Stores intrinsic state
3. **Flyweight Factory** (`TreeFactory`) - Manages shared flyweights
4. **Context** (`TreeObject`) - Stores extrinsic state

### Example: Forest Simulation
A forest has thousands of trees. Instead of storing name, color, and texture for each tree, we share `TreeType` objects and only store position per tree.

```java
// Usage
TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
// Same type returned for subsequent calls - no new object created
TreeType sameOakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
```

## Intrinsic vs Extrinsic State

| Intrinsic (Shared) | Extrinsic (Unique) |
|-------------------|-------------------|
| Tree name | Position (x, y) |
| Color | Age |
| Texture | Size |
| Bark type | Health status |

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Flyweight Interface                         │
│                       (Tree)                                 │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + display(x, y)                                     │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│               Concrete Flyweight                   │
│                   (TreeType)                       │
│  ┌─────────────────────────────────────────────┐  │
│  │ Intrinsic State (shared):                   │  │
│  │ - name                                      │  │
│  │ - color                                     │  │
│  │ - texture                                   │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
                          │ creates/manages
┌─────────────────────────┴─────────────────────────┐
│               Flyweight Factory                    │
│                (TreeFactory)                       │
│  ┌─────────────────────────────────────────────┐  │
│  │ - treeTypes: Map<String, TreeType>          │  │
│  │ + getTreeType(): TreeType                   │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    Context                                   │
│                  (TreeObject)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ Extrinsic State (unique):                           │    │
│  │ - x, y (position)                                   │    │
│  │ - treeType (reference to flyweight)                 │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

## Pros
- ✅ Significant memory savings
- ✅ Reduces number of objects
- ✅ Separates intrinsic and extrinsic state
- ✅ Shared objects are thread-safe (immutable)

## Cons
- ❌ Increased complexity
- ❌ Extrinsic state must be managed separately
- ❌ May impact performance (state lookup)
- ❌ Not suitable if extrinsic state is large

## When to Use
- When many similar objects consume too much memory
- When object state can be separated into shared and unique parts
- When objects are mostly immutable
- When object identity doesn't matter (only state)

## Flyweight vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Flyweight | Share objects to save memory |
| Singleton | One instance per class |
| Factory | Create objects |
| Prototype | Clone existing objects |

## Related Patterns
- **Composite**: Flyweights can be leaf nodes
- **Factory**: Used to create flyweights
- **Singleton**: Flyweights are often singletons
- **Strategy**: Can share strategy objects

## Real-World Examples
- Text editors (character formatting)
- Game development (particles, bullets)
- Graphics (reusing shapes, colors)
- Database connection pools
- String interning in Java
