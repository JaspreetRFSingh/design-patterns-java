# KISS — Keep It Simple, Stupid

## Overview
**Simplicity should be a key goal in design. Unnecessary complexity should be avoided.**

> "Everything should be made as simple as possible, but not simpler." — Albert Einstein
> "Simplicity is the ultimate sophistication." — Leonardo da Vinci
> "Any fool can write code that a computer can understand. Good programmers write code that humans can understand." — Martin Fowler

## Problem
Developers often reach for patterns, abstractions, and frameworks when simple, direct code would do:

```java
// BAD: four strategy classes + pipeline + result wrapper just to check four conditions
interface ValidationRule { ValidationResult validate(String password); }
class LengthRule implements ValidationRule { ... }
class UpperCaseRule implements ValidationRule { ... }
class DigitRule implements ValidationRule { ... }
class SpecialCharRule implements ValidationRule { ... }
// ... and a loop to run them all
```

This is legitimate architecture for a configurable, user-extensible rule engine. For a fixed four-rule password check, it is massive overkill.

## Solution
Write the simplest code that correctly solves the problem:

```java
// GOOD: four readable boolean checks
public boolean validate(String password) {
    if (password.length() < 8) { ... return false; }
    if (!password.chars().anyMatch(Character::isUpperCase)) { ... return false; }
    if (!password.chars().anyMatch(Character::isDigit)) { ... return false; }
    if (!password.chars().anyMatch(c -> "!@#$%^&*".indexOf(c) >= 0)) { ... return false; }
    return true;
}
```

## Signs You're Violating KISS

| Smell | Description |
|---|---|
| Premature abstraction | Adding Strategy/Factory/Builder where a simple method would suffice |
| Indirection explosion | Every operation goes through 5 layers of delegation |
| "Just in case" parameters | Methods take extra args that are never used |
| Framework for two cases | Using a plugin architecture for two hard-coded variants |
| Class for one call | Creating a class whose entire job is one method call |

## KISS vs Other Principles

- **KISS and DRY can conflict**: DRY says extract shared logic, but sometimes duplication IS simpler. Prefer the clearer code.
- **KISS and OCP can conflict**: OCP wants extensibility, but building for imaginary extensions violates KISS. Apply OCP when the variation actually exists.
- **KISS and YAGNI align**: both say don't build what you don't need yet.

## Pros
- ✅ Easier to read and understand
- ✅ Fewer bugs — less code = less to go wrong
- ✅ Faster to write and review
- ✅ Easier to onboard new developers

## Cons
- ❌ Simple solutions can become hard to extend later (but that's a future problem)
- ❌ Requires judgment — "simple" is subjective

## When to Reach for Complexity
Complexity is justified when:
- The domain is genuinely complex (not the code adding complexity)
- You have proven extensibility requirements, not imagined ones
- Performance profiling shows the simple solution is too slow

## Related Principles
- **YAGNI** — don't add features you don't need yet
- **DRY** — eliminate duplication, but not at the cost of clarity
- **SRP** — simple classes with one job tend to be simpler overall
