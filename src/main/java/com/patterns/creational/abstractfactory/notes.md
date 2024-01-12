# Abstract Factory Pattern

## Overview
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

## Problem
An application needs to support multiple UI themes (Windows, Mac, Linux). Each theme has its own style of buttons, checkboxes, menus, etc. All components of the same theme must work together consistently.

## Solution
Create a factory interface that can produce all types of related products. Each concrete factory produces one family of products (one theme).

## Implementation Details

### Key Components
1. **Abstract Products** (`Button`, `Checkbox`) - Interfaces for each product type
2. **Concrete Products** (`WindowsButton`, `MacButton`, `WindowsCheckbox`, `MacCheckbox`)
3. **Abstract Factory** (`GUIFactory`) - Interface declaring creation methods
4. **Concrete Factories** (`WindowsFactory`, `MacFactory`) - Implement the factory
5. **Client** (`Application`) - Uses the factory to create products

### Example: Cross-Platform UI
The `GUIFactory` interface declares methods to create buttons and checkboxes. `WindowsFactory` creates Windows-style components, while `MacFactory` creates Mac-style components.

```java
// Usage
GUIFactory factory = new MacFactory();
Application app = new Application(factory);
app.paint(); // All components use Mac style
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                    Abstract Factory                          │
│                    (GUIFactory)                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + createButton(): Button                            │    │
│  │ + createCheckbox(): Checkbox                        │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│ WindowsFactory │                 │   MacFactory   │
├────────────────┤                 ├────────────────┤
│ createButton() │                 │ createButton() │
│   → WindowsBtn │                 │   → MacButton  │
│ createCheckbox()│                │ createCheckbox()│
│   → WinCheckbox│                 │   → MacCheckbox│
└────────────────┘                 └────────────────┘
```

## Pros
- ✅ Ensures consistency between products in a family
- ✅ Single Responsibility Principle - Creation code in one place
- ✅ Open/Closed Principle - Easy to add new product families
- ✅ Client code decoupled from concrete classes

## Cons
- ❌ Increased complexity with many interfaces and classes
- ❌ Hard to support new kinds of products (need to change factory interface)
- ❌ Can lead to class explosion

## When to Use
- When a system needs to be independent of how its products are created
- When a system should be configured with one of multiple families of products
- When a family of related products must be used together
- When you want to provide a library of products without exposing implementation

## Abstract Factory vs Factory Method
| Aspect | Factory Method | Abstract Factory |
|--------|---------------|------------------|
| Scope | Creates one product | Creates families of products |
| Pattern | Inheritance-based | Composition-based |
| Complexity | Simpler | More complex |

## Related Patterns
- **Factory Method**: Often used to implement Abstract Factory
- **Prototype**: Can be used instead of Abstract Factory when creation is complex
- **Singleton**: Concrete factories are often singletons
- **Builder**: Complex factories may use Builder for product construction
