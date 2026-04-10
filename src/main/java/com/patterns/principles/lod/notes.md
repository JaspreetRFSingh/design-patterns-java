# Law of Demeter (LoD) — Principle of Least Knowledge

## Overview
A method should only call methods on:
1. The object itself (`this`)
2. Its own fields
3. Objects passed as arguments
4. Objects it creates locally

**A method should NOT call methods on objects returned by other method calls.**

> "Only talk to your immediate friends." — Law of Demeter, Northeastern University (1987)

## Problem
"Train-wreck" code traverses object graphs to accomplish operations:

```java
// BAD: caller knows about Person, Wallet, AND Money
double balance = person.getWallet().getMoney().getAmount();
person.getWallet().deductMoney(30.0);
```

Problems:
- Caller is tightly coupled to Person **and** Wallet **and** Money
- Changing Wallet's internal structure (e.g., removing Money class) breaks the caller
- If Wallet is null, `NullPointerException` is hard to trace
- Breaks encapsulation — internal structure of Wallet is visible to everyone

## Solution
Expose only meaningful operations. Objects coordinate with their own collaborators:

```java
// GOOD: caller only talks to Person
person.pay(30.0);

// Person internally coordinates with Wallet:
public boolean pay(double amount) {
    if (!wallet.hasSufficientFunds(amount)) { return false; }
    wallet.deduct(amount);
    return true;
}
```

Caller knows only about `Person`. It doesn't know or care that a `Wallet` exists.

## The One-Dot Rule (Simplified)
A common heuristic: **one method call per chain** (though this oversimplifies — fluent builders and stream pipelines are fine).

The real question: **does the caller need to know about the returned object's type and structure?**

```java
// OK — fluent API on same type / builder
order.withItem("milk").withItem("eggs").build();

// OK — stream pipeline, stays within one domain
list.stream().filter(...).map(...).collect(...);

// VIOLATION — traversing unrelated object boundaries
customer.getAccount().getCard().getLimit();
```

## Key Components

| Class | Role |
|---|---|
| `Person` | Facade for its collaborators — exposes `pay()` |
| `Wallet` | Manages its own balance, exposes `deduct()` / `hasSufficientFunds()` |
| Caller | Only knows `Person` — zero coupling to `Wallet` |

## Pros
- ✅ Loose coupling — changes to Wallet don't affect callers
- ✅ Better encapsulation — internals stay internal
- ✅ Easier to test — only need to mock `Person`, not `Wallet` and `Money`
- ✅ Clearer intent — `person.pay(30)` reads naturally

## Cons
- ❌ More "wrapper" methods on intermediate objects (`Person.getBalance()`, `Person.pay()`)
- ❌ Can lead to bloated interfaces if overused
- ❌ Not appropriate for all patterns (e.g., builder chains, stream pipelines)

## When to Use
- When callers navigate multiple hops to do something that the intermediate object should do
- When changes to an internal class ripple unexpectedly to callers
- When writing code that touches domain model boundaries

## When NOT to Use
- Fluent builders, stream pipelines — they are designed to chain
- When adding wrapper methods would add more complexity than the chaining

## Related Principles
- **Encapsulation** — LoD enforces encapsulation at the interaction level
- **Single Responsibility** — each object does its own job without exposing internals
- **Tell, Don't Ask** — related heuristic: tell objects to do things rather than asking for data
