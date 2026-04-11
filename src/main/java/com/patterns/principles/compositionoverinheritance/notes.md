# Composition over Inheritance

## Overview
**Favour object composition over class inheritance** as a reuse mechanism. Build behaviour by combining objects with capabilities rather than by extending a parent class.

> "Favor object composition over class inheritance." — Gang of Four, *Design Patterns*

## Problem
Deep inheritance hierarchies become brittle. Changes to base classes ripple to all subclasses. Java's single-inheritance model makes it impossible to share behaviour from multiple sources:

```java
// BAD: Vehicle base class encodes ALL possible capabilities
class VehicleViolation {
    public void drive() { ... }        // most vehicles
    public void fly()   { throw ... }  // only some vehicles
    public void swim()  { throw ... }  // only some vehicles
}

class CarViolation extends VehicleViolation {
    // inherits fly() and swim() — but they throw UnsupportedOperationException
    // LSP violated, dead methods pollute the interface
}

// Impossible in Java — no multiple inheritance:
class FlyingCar extends Car, Airplane { } // COMPILE ERROR
```

## Solution
Define capabilities as interfaces. Objects compose only the capabilities they need:

```java
interface Drivable  { void drive(); }
interface Flyable   { void fly();   }
interface Swimmable { void swim();  }

class Car        implements Drivable              { ... }
class Airplane   implements Drivable, Flyable     { ... }
class Amphibian  implements Drivable, Swimmable   { ... }
class FlyingCar  implements Drivable, Flyable, Swimmable { ... }
```

No inheritance hierarchy, no phantom methods, no LSP violations.

## Inheritance vs Composition

| | Inheritance | Composition |
|---|---|---|
| Relationship | **is-a** | **has-a** / **can-do** |
| Coupling | Tight (subclass coupled to superclass) | Loose (object coupled to interface) |
| Flexibility | Low — fixed at compile time | High — can change at runtime |
| Multiple sources | Not possible in Java | Easy — implement multiple interfaces |
| Encapsulation | Subclass sees superclass internals | Composed object's internals stay hidden |

## When Inheritance IS Appropriate

Inheritance is the right tool when:
- The relationship is genuinely **is-a** (not just "shares code with")
- The subtype honours LSP fully — can substitute the parent everywhere
- The parent class is designed for extension (abstract class with template methods)

## Object Composition (Delegation)

Beyond interfaces, composition also means **holding a reference** to a collaborator and delegating:

```java
// Car HAS-A Engine — not IS-A Engine
public class Car {
    private final Engine engine; // composed object
    public void start() { engine.start(); } // delegated
}
```

This lets you swap the engine at runtime, mock it in tests, and change Engine without touching Car.

## Pros
- ✅ More flexible — compose capabilities at runtime, not just compile time
- ✅ Avoids fragile base class problem
- ✅ Works around Java's single-inheritance limitation
- ✅ Smaller, focused classes

## Cons
- ❌ More classes to manage when many capabilities are composed
- ❌ Delegation code (wrapper methods) can be verbose without language support (Kotlin delegation syntax helps)
- ❌ Harder to see the full behaviour of a class without tracing delegations

## Related Principles & Patterns
- **Liskov Substitution** — inheritance breaks LSP when the subtype can't fulfil the contract
- **Interface Segregation** — small, capability-specific interfaces are the building blocks
- **Strategy Pattern** — behaviour composed via an injected strategy object
- **Decorator Pattern** — adds behaviour by composing, not extending
- **Bridge Pattern** — separates abstraction from implementation via composition
