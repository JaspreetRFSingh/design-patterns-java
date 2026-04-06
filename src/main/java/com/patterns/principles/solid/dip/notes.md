# Dependency Inversion Principle (DIP)

## Overview
Two rules:
1. **High-level modules should not depend on low-level modules. Both should depend on abstractions.**
2. **Abstractions should not depend on details. Details should depend on abstractions.**

> "Depend upon abstractions. Do not depend upon concretions." — Robert C. Martin

## Problem
When a high-level class creates or directly references a low-level class, they become tightly coupled. Changing the low-level detail forces changes to the high-level module:

```java
// BAD: high-level class instantiates a concrete low-level class
public class ReportGeneratorViolation {
    private final PDFFormatterViolation formatter = new PDFFormatterViolation();
    // Switching to HTML requires editing this class
}
```

The dependency arrow points downward: `ReportGenerator → PDFFormatter`.

## Solution
Introduce an abstraction. Both layers depend on it; neither depends on the other:

```
ReportGenerator  →  ReportFormatter (interface)  ←  PDFFormatter
                                                  ←  HTMLFormatter
                                                  ←  CSVFormatter
```

The formatter is **injected** rather than created internally:

```java
public class ReportGenerator {
    private final ReportFormatter formatter; // depends on abstraction

    public ReportGenerator(ReportFormatter formatter) {
        this.formatter = formatter; // injected from outside
    }
}
```

## Key Components

| Class/Interface | Layer | Depends on |
|---|---|---|
| `ReportFormatter` | Abstraction | nothing |
| `ReportGenerator` | High-level | `ReportFormatter` abstraction |
| `PDFFormatter` | Low-level detail | `ReportFormatter` abstraction |
| `HTMLFormatter` | Low-level detail | `ReportFormatter` abstraction |

## DIP vs Dependency Injection
- **DIP** is the **principle** — depend on abstractions, not concretions
- **Dependency Injection** is one **technique** to satisfy DIP (constructor, setter, or field injection)
- A DI framework (Spring, Guice) automates the wiring but DIP is the goal

## Pros
- ✅ High-level policy is insulated from low-level implementation changes
- ✅ Easy to swap implementations (different formatter, mock in tests)
- ✅ Promotes testability — inject a fake formatter in unit tests
- ✅ Enables parallel development of high-level and low-level modules

## Cons
- ❌ More abstractions to define and maintain
- ❌ Indirection can make code harder to trace for new developers
- ❌ Overuse leads to interface explosion

## When to Use
- Whenever high-level business logic depends on I/O, infrastructure, or external services
- When you want to unit-test high-level modules in isolation
- When implementations are expected to change or vary

## When NOT to Use
- For simple value-object helpers unlikely to change
- When the abstraction has only one implementation and that will never change

## Related Principles & Patterns
- **Dependency Injection Pattern** — concrete implementation of DIP
- **Open/Closed Principle** — DIP enables OCP by allowing extensions via new implementations
- **Strategy Pattern** — injects interchangeable algorithms, a direct application of DIP
- **Abstract Factory** — creates families of objects behind an abstraction
