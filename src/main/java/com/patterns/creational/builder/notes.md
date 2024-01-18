# Builder Pattern

## Overview
The Builder pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Problem
Creating complex objects with many optional parameters leads to:
- Telescoping constructors (many overloaded constructors)
- Hard-to-read code with many parameters
- Immutable objects difficult to create

## Solution
Use a builder object that receives configuration step by step and then creates the final object.

## Implementation Details

### Key Components
1. **Product** (`House`) - The complex object being built
2. **Builder Interface** (`HouseBuilder`) - Specifies steps for building
3. **Concrete Builders** (`WoodenHouseBuilder`, `ConcreteHouseBuilder`) - Implement building steps
4. **Director** (`ConstructionEngineer`) - Orchestrates the construction

### Example: House Construction
The `House` class has a nested `Builder` class for fluent construction. Different `HouseBuilder` implementations can build different types of houses using the same construction process.

```java
// Fluent builder usage
House house = new House.Builder("Foundation", "Structure", "Roof")
    .setHasGarage(true)
    .setHasSwimmingPool(true)
    .setNumberOfWindows(10)
    .build();
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                      Director                                │
│              (ConstructionEngineer)                          │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + constructHouse(): House                           │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │ uses
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                    Builder Interface                         │
│                    (HouseBuilder)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + buildFoundation()                                 │    │
│  │ + buildStructure()                                  │    │
│  │ + buildRoof()                                       │    │
│  │ + ...                                               │    │
│  │ + getHouse(): House                                 │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│ WoodenHouse    │                 │ ConcreteHouse  │
│    Builder     │                 │    Builder     │
└────────────────┘                 └────────────────┘
```

## Pros
- ✅ Construct complex objects step by step
- ✅ Reuse same construction code for different representations
- ✅ Single Responsibility Principle - Construction logic isolated
- ✅ Immutable objects with fluent API
- ✅ Clear, readable code for object creation

## Cons
- ❌ Increased number of classes
- ❌ Can be overkill for simple objects
- ❌ Client must understand builder API

## When to Use
- When object creation involves many steps or parameters
- When different representations of a product are needed
- When you want to create immutable objects with optional parameters
- When construction process should be independent of object parts

## Builder vs Other Creational Patterns
| Pattern | Focus |
|---------|-------|
| Builder | Step-by-step construction |
| Abstract Factory | Creating product families |
| Factory Method | Single product creation |

## Related Patterns
- **Abstract Factory**: Can use Builder for complex product creation
- **Composite**: Builder can create complex tree structures
- **Template Method**: Director uses a template-like approach
- **Singleton**: Builders can be singletons if stateless
