# Open/Closed Principle (OCP)

## Overview
Software entities (classes, modules, functions) should be **open for extension but closed for modification**.

> "You should be able to extend a class's behavior without modifying it." — Robert C. Martin / Bertrand Meyer

## Problem
When adding new behavior requires editing existing, tested code, you risk breaking what already works:

```java
// BAD: adding Triangle forces editing this method every time
public double calculateArea(Object shape) {
    if (shape instanceof Circle c) { ... }
    else if (shape instanceof Rectangle r) { ... }
    // must add else-if for every new shape!
}
```

Symptoms of OCP violation:
- Long `if-else` or `switch` chains on type
- Frequent edits to core logic classes
- Tests for old shapes break when adding new ones

## Solution
Define a stable abstraction that new types implement. The calculator never changes:

```java
public interface Shape {
    double area();
}

// AreaCalculator is written once and never touched again
public class AreaCalculator {
    public double totalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}
```

Adding `Triangle` = create a new class, zero edits elsewhere.

## Key Components

| Element | Role |
|---|---|
| `Shape` (interface) | Stable abstraction — never changes |
| `Circle`, `Rectangle`, `Triangle` | Extensions — added freely |
| `AreaCalculator` | Closed for modification — works with any Shape |

## How OCP Is Achieved

1. **Abstraction** — define interfaces or abstract classes
2. **Polymorphism** — let runtime dispatch handle type differences
3. **Strategy / Template Method patterns** — common OCP enablers

## Pros
- ✅ New functionality = new code, not changed code
- ✅ Existing tests stay green
- ✅ Reduces regression risk
- ✅ Promotes reuse of stable abstractions

## Cons
- ❌ Requires upfront design of good abstractions
- ❌ Wrong abstraction is worse than none — hard to refactor later
- ❌ Can lead to many small classes if over-applied

## When to Use
- When behavior varies and new variants are likely to be added
- When changing a class carries high risk (many callers, no tests)
- When building a plugin or extension point in a framework

## When NOT to Use
- When the domain is truly stable and new types are never added
- When the abstraction isn't clear — wait until the second or third case appears ("Rule of Three")

## Related Principles & Patterns
- **Strategy Pattern** — swappable algorithms, closed to modification
- **Decorator Pattern** — adds behavior without modifying decorated class
- **Factory Method** — creates objects without modifying caller
- **Liskov Substitution Principle** — ensures subtypes can be used in place of abstractions safely
