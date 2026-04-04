# Liskov Substitution Principle (LSP)

## Overview
If S is a subtype of T, then objects of type T may be **replaced with objects of type S** without altering any of the desirable properties of the program.

In plain terms: **subtypes must honour the contracts of their supertypes.**

> "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it." — Barbara Liskov

## Problem
When a subclass overrides a method in a way that breaks the contract the superclass established, callers can no longer trust the abstraction:

```java
// BAD: BirdViolation.fly() implies "this bird can fly"
class PenguinViolation extends BirdViolation {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
}

// Caller code breaks at runtime with no compile-time warning:
for (BirdViolation bird : birds) {
    bird.fly(); // BOOM for Penguin
}
```

## Solution
Model the type hierarchy so every subtype honours every method it inherits. Move capabilities that not all subtypes share into separate interfaces:

```
Bird (abstract)
 ├── Eagle implements Flyable  ← can fly
 ├── Sparrow implements Flyable ← can fly
 └── Penguin                   ← cannot fly, has swim()

interface Flyable { void fly(); }
```

## LSP Contract Rules

A subtype must obey all of these relative to its supertype:

| Rule | Meaning |
|---|---|
| Preconditions | Subtype cannot strengthen — must accept everything supertype accepts |
| Postconditions | Subtype cannot weaken — must deliver at least what supertype promises |
| Invariants | Class invariants must be preserved |
| History constraint | No new methods that mutate state in ways the supertype forbids |
| No exception weakening | Cannot throw new checked exceptions not declared in supertype |

## Pros
- ✅ Polymorphism works safely without surprises
- ✅ Code using the base type doesn't need instanceof checks
- ✅ Easier to add new subtypes later

## Cons
- ❌ Requires careful design of base abstractions upfront
- ❌ Can be subtle — violations aren't always compile-time errors

## When to Use
- Always when using inheritance — it's a correctness requirement, not optional
- When reviewing inheritance hierarchies for hidden runtime failures

## When NOT to Over-Apply
- Don't force unnatural hierarchies just to reuse code — prefer composition

## Common LSP Violations to Watch For
- Overriding a method to throw `UnsupportedOperationException`
- Returning `null` where the supertype promises a non-null result
- A subtype that narrows the accepted input types
- A subtype that silently ignores operations (no-op overrides)

## Related Principles
- **Open/Closed Principle** — OCP relies on LSP: extensions must be safe substitutes
- **Interface Segregation** — small interfaces are easier to honour fully
- **Composition over Inheritance** — alternative when inheritance hierarchy would violate LSP
