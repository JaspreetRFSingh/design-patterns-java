# Decorator Pattern

## Overview
The Decorator pattern attaches additional responsibilities to objects dynamically. It provides a flexible alternative to subclassing for extending functionality.

## Problem
You need to add features to objects at runtime. Using inheritance would lead to class explosion (SimpleCoffee, CoffeeWithMilk, CoffeeWithSugar, CoffeeWithMilkAndSugar, etc.).

## Solution
Wrap objects with decorator classes that add behavior while maintaining the same interface.

## Implementation Details

### Key Components
1. **Component** (`Coffee`) - Interface for objects that can be decorated
2. **Concrete Component** (`SimpleCoffee`) - Original object
3. **Decorator** (`CoffeeDecorator`) - Base decorator holding component reference
4. **Concrete Decorators** (`MilkDecorator`, `SugarDecorator`, etc.) - Add specific behaviors

### Example: Coffee Shop
Each decorator wraps a coffee and adds its own cost and description. Decorators can be stacked to create custom combinations.

```java
// Usage
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);
// Result: "Simple Coffee + Milk + Sugar" - $2.75
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Component Interface                        │
│                      (Coffee)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + getCost(): double                                 │    │
│  │ + getDescription(): String                          │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│ConcreteComponent│                 │   Decorator    │
│ (SimpleCoffee)  │                 │(CoffeeDecorator)│
├────────────────┤                 ├────────────────┤
│ getCost()      │                 │ - coffee       │
│ getDescription()│                │ getCost()      │
└────────────────┘                 │ getDescription()│
                                   └────────────────┘
                                           ▲
                    ┌──────────┬───────────┼───────────┬──────────┐
                    │          │           │           │          │
              ┌─────▼────┐ ┌───▼────┐ ┌────▼────┐ ┌───▼────┐ ┌───▼────┐
              │   Milk   │ │ Sugar  │ │Whipped  │ │Espresso│ │  ...   │
              │Decorator │ │Decorator│ │CreamDec │ │Decorator│        │
              └──────────┘ └────────┘ └─────────┘ └────────┘ └────────┘
```

## Decorator Chain
```
SimpleCoffee ($2.00)
    ↓ wrapped by
MilkDecorator (+$0.50 = $2.50)
    ↓ wrapped by
SugarDecorator (+$0.25 = $2.75)
    ↓ wrapped by
EspressoDecorator (+$1.50 = $4.25)
```

## Pros
- ✅ More flexible than inheritance
- ✅ Add/remove responsibilities at runtime
- ✅ Avoids class explosion
- ✅ Single Responsibility Principle - Each decorator has one job
- ✅ Open/Closed Principle - Add new decorators without changing existing code

## Cons
- ❌ Many small classes can be overwhelming
- ❌ Hard to debug decorator chains
- ❌ Can lead to deeply nested objects
- ❌ Order of decoration may matter

## Decorator vs Inheritance

| Inheritance | Decorator |
|-------------|-----------|
| Static, compile-time | Dynamic, runtime |
| One combination per class | Any combination possible |
| Class explosion | Flexible composition |

## When to Use
- When you need to add responsibilities dynamically
- When subclassing is impractical (too many combinations)
- When responsibilities can be added/removed at runtime
- When you want to follow Open/Closed Principle

## Decorator vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Decorator | Add responsibilities |
| Composite | Part-whole hierarchies |
| Strategy | Change behavior/algorithm |
| Adapter | Convert interface |

## Related Patterns
- **Composite**: Both use recursive composition
- **Strategy**: Both wrap objects, different intent
- **Observer**: Can be combined for event handling
- **Flyweight**: Can share decorated objects

## Real-World Examples
- Java I/O streams (`BufferedInputStream`, `DataInputStream`)
- Servlet filters
- Spring AOP proxies
- Middleware in web frameworks
