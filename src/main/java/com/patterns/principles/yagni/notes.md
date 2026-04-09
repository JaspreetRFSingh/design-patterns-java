# YAGNI — You Aren't Gonna Need It

## Overview
**Don't implement something until it is actually needed.**

> "Always implement things when you actually need them, never when you just foresee that you need them." — Ron Jeffries (XP)
> "You Aren't Gonna Need It." — Extreme Programming

## Problem
Developers often add features "just in case" they'll be needed:

```java
// BAD: built for imagined future requirements
public class UserServiceViolation {
    public void addUser(String username) { ... }      // ← needed
    public void assignRole(String u, String role) { } // ← not asked for
    public void logAuditEvent(String u, String a) { } // ← not asked for
    public String exportToCSV() { ... }               // ← not asked for
    public void archiveUser(String username) { }      // ← not asked for
    public void registerPlugin(Object plugin) { }     // ← not asked for
}
```

Problems with speculative features:
1. **Time wasted** building something that may never be used
2. **Wrong design** — requirements often turn out different from the guess
3. **More code to maintain** — dead code still needs reading, reviewing, testing
4. **Complexity** — future developers wonder why features exist and if they're safe to change

## Solution
Build only what is required now. Trust that you can add features when they are actually needed — at which point requirements will be clear:

```java
// GOOD: only what is actually required
public class UserService {
    public void addUser(String username) { ... }
    public String getUser(int index) { ... }
    public int getUserCount() { ... }
}
```

## Cost of Speculative Features

| Speculative Code | Actual Cost |
|---|---|
| Implemented but never called | Maintenance burden, confusion |
| Implemented and called incorrectly | Bug |
| Implemented correctly for wrong use case | Rework when real requirement arrives |
| Not implemented | Zero cost — add it when needed |

## YAGNI vs Good Design

YAGNI does **not** mean "write throwaway code":
- Write clean, well-structured code for today's requirements
- Design with seams so future extension is possible without rewriting (OCP)
- YAGNI just says: don't fill those seams with speculative implementations

## Pros
- ✅ Ships faster — focus on what's asked
- ✅ Less code to understand, test, and maintain
- ✅ Avoids designing for wrong requirements
- ✅ Keeps codebase lean

## Cons
- ❌ Occasionally you do need it — then you add it (acceptable cost)
- ❌ Poorly applied, it can justify sloppy architecture that is hard to extend

## When to Apply
- Always — unless there is a concrete, specified, imminent requirement for a feature
- Especially during early-stage development when requirements evolve frequently

## Related Principles
- **KISS** — YAGNI keeps the scope small; KISS keeps the implementation simple
- **Single Responsibility** — features added for imagined futures often blur responsibilities
- **Agile/Incremental development** — deliver working software in small increments, add as needed
