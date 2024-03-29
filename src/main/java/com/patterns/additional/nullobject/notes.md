# Null Object Pattern

## Overview
The Null Object pattern provides a default do-nothing object that implements the expected interface, eliminating the need for null checks.

## Problem
Code is filled with null checks before calling methods. This leads to verbose, error-prone code and potential NullPointerExceptions.

## Solution
Create a null object that implements the same interface but provides neutral default behavior. Return this instead of null.

## Implementation Details

### Key Components
1. **Abstract Class** (`Animal`) - Common interface
2. **Real Objects** (`Dog`, `Cat`) - Actual implementations
3. **Null Object** (`NullAnimal`) - Default do-nothing implementation

### Example: Animal Registry
When an animal is not found, return `NullAnimal` instead of null. Client code can safely call methods without null checks.

```java
// Without Null Object
Animal animal = registry.getAnimal("pet1");
if (animal != null) {
    animal.makeSound();
}

// With Null Object
Animal animal = registry.getAnimal("pet1");
animal.makeSound(); // Always safe
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Abstract Class                              │
│                     (Animal)                                 │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + makeSound() [ABSTRACT]                            │    │
│  │ + move() [ABSTRACT]                                 │    │
│  │ + getInfo() [ABSTRACT]                              │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │   Dog   │      │    Cat    │     │   Null  │
   │         │      │           │     │ Animal  │
   └─────────┘      └───────────┘     └─────────┘
                                       (Singleton)
```

## Pros
- ✅ No null checks needed
- ✅ No NullPointerException
- ✅ Clean, readable code
- ✅ Predictable behavior
- ✅ Single Responsibility - Null behavior encapsulated

## Cons
- ❌ May hide bugs (missing data silently ignored)
- ❌ Additional class
- ❌ Null object behavior may not always be appropriate

## When to Use
- When null checks are pervasive
- When default do-nothing behavior is acceptable
- For optional features
- When you want to avoid NullPointerException

## When NOT to Use
- When null has semantic meaning that must be detected
- When missing data should cause an error
- When null object behavior would be misleading

## Related Patterns
- **Singleton**: Null objects are often singletons
- **State**: Null can be a state
- **Strategy**: Null can be a strategy

## Real-World Examples
- Java `Collections.emptyList()`
- Java `Optional.orElse()`
- Spring `NullChannel`
- Logging frameworks (NullAppender)
