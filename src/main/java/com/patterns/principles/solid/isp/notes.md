# Interface Segregation Principle (ISP)

## Overview
Clients should not be forced to depend on interfaces they do not use. Prefer **many small, specific interfaces** over one large, general-purpose interface.

> "Make fine-grained interfaces that are client-specific." — Robert C. Martin

## Problem
A fat interface forces all implementors to provide methods that may be meaningless to them:

```java
// BAD: single interface mixing unrelated capabilities
interface WorkerViolation {
    void work();
    void eat();   // irrelevant for machines
    void sleep(); // irrelevant for machines
}

class RobotViolation implements WorkerViolation {
    public void eat()   { throw new UnsupportedOperationException(); }
    public void sleep() { throw new UnsupportedOperationException(); }
}
```

Problems this causes:
- Callers that only need `work()` still compile-time depend on `eat()` and `sleep()`
- Changes to `eat()` force recompilation of `Robot` even though it doesn't use it
- UnsupportedOperationException = LSP violation waiting to happen

## Solution
Split into focused interfaces — each client only sees what it needs:

```java
interface Workable  { void work(); }
interface Eatable   { void eat();  }
interface Sleepable { void sleep(); }

class Robot implements Workable { ... }              // no stubs
class HumanWorker implements Workable, Eatable, Sleepable { ... }
```

## Key Components

| Interface | Who implements it |
|---|---|
| `Workable` | Both `HumanWorker` and `Robot` |
| `Eatable` | `HumanWorker` only |
| `Sleepable` | `HumanWorker` only |

## Interface Size Guidelines

- An interface should represent **one role or capability**
- If implementing class would stub out or throw from a method, that method doesn't belong in the interface
- Favour composition of small interfaces over wide single interfaces

## Pros
- ✅ Implementations are lean — no forced stubs or exceptions
- ✅ Smaller interfaces are easier to implement and mock in tests
- ✅ Changes to one capability don't ripple across unrelated implementors
- ✅ Encourages thinking about roles, not entities

## Cons
- ❌ More interfaces to manage
- ❌ Can be taken too far — one-method interfaces everywhere becomes noise

## When to Use
- When several classes implement an interface but stub out or throw in several methods
- When a large interface is used differently by different callers
- When designing a plugin/extension API used by many third parties

## When NOT to Use
- When all implementors genuinely need all methods
- For simple CRUD repositories where all methods are always relevant

## Related Principles
- **Single Responsibility** — ISP is SRP applied to interfaces
- **Liskov Substitution** — small interfaces are easier to honour fully (no thrown exceptions)
- **Dependency Inversion** — narrow interfaces make dependencies smaller and easier to swap
