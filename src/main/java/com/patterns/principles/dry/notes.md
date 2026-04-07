# DRY — Don't Repeat Yourself

## Overview
**Every piece of knowledge must have a single, unambiguous, authoritative representation within a system.**

> "Don't Repeat Yourself — every piece of knowledge must have a single, unambiguous, authoritative representation." — Andrew Hunt & David Thomas, *The Pragmatic Programmer*

## Problem
Duplicating logic creates multiple sources of truth. When a rule changes, every copy must be updated — but usually only some are:

```java
// BAD: same discount + tax logic appears in processOnlineOrder AND processInStoreOrder
double discount = 0;
if ("PREMIUM".equals(customerType)) discount = subtotal * 0.15;
else if ("REGULAR".equals(customerType)) discount = subtotal * 0.05;
double tax = afterDiscount * 0.08;
```

When the tax rate changes from 8% to 9%, the developer who updates `processOnlineOrder` may forget `processInStoreOrder` — a subtle, hard-to-detect bug.

## Solution
Extract shared logic into a single authoritative place:

```java
// Single source of truth for pricing rules
public class PricingUtils {
    public static double applyDiscount(double subtotal, String type) { ... }
    public static double applyTax(double amount) { ... }
    public static double finalTotal(double subtotal, String type) { ... }
}
```

Both `processOnlineOrder` and `processInStoreOrder` delegate to `PricingUtils`. A tax change requires editing **one line** in one place.

## What DRY Covers

DRY is broader than just copy-paste code. It applies to:

| Type | Example |
|---|---|
| **Logic** | Duplicated calculation or algorithm |
| **Data** | Same constant defined in multiple files |
| **Documentation** | Same explanation in code and external docs |
| **Build** | Same configuration repeated in multiple scripts |
| **Schema** | Same structure defined in DB and Java and API spec |

## Pros
- ✅ Change in one place propagates everywhere automatically
- ✅ Fewer bugs from inconsistent updates
- ✅ Easier to understand — one place to look up the rule
- ✅ Smaller codebase overall

## Cons
- ❌ Premature abstraction can cause wrong coupling — "accidental duplication"
- ❌ Overly DRY code can be hard to read (too many layers of indirection)

## DRY vs "Accidental Duplication"
Not all similar-looking code is the same knowledge:
- Two validation methods that both check for null may be **separate knowledge** that happens to look the same. If the rules diverge later, coupling them was wrong.
- Wait for the third repetition before extracting (Rule of Three).

## When to Use
- When the same calculation, rule, or constant appears more than once
- When two places must always stay in sync

## When NOT to Use
- When similar-looking code represents genuinely different concepts
- When extracting would create a confusing over-generalized abstraction

## Related Principles
- **Single Responsibility Principle** — SRP organises code; DRY eliminates redundancy
- **KISS** — sometimes repeating is simpler and clearer than a complex shared abstraction
- **YAGNI** — don't DRY things that aren't actually the same knowledge
