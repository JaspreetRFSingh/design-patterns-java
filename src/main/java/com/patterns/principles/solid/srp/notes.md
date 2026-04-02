# Single Responsibility Principle (SRP)

## Overview
A class should have **one, and only one, reason to change**. Each class should encapsulate a single responsibility — a single part of the system's functionality.

> "A class should have only one reason to change." — Robert C. Martin

## Problem
When a class handles multiple concerns, any change to one concern forces you to touch (and retest) code unrelated to that change:

```java
// BAD: UserViolation does user data, validation, DB persistence, AND email
public class UserViolation {
    public boolean isValid() { ... }
    public void saveToDatabase() { ... }  // knows about DB
    public void sendWelcomeEmail() { ... } // knows about SMTP
}
```

This class has **four reasons to change**:
1. User data fields change
2. Validation rules change
3. Database technology changes
4. Email provider changes

## Solution
Split into focused classes, each with a single reason to change:

```
User           — holds user data
UserValidator  — validates user data
UserRepository — persists users to DB
EmailService   — sends emails
```

## Key Components

| Class | Responsibility | Reason to Change |
|---|---|---|
| `User` | Hold user data | User data model changes |
| `UserValidator` | Validate user | Validation rules change |
| `UserRepository` | Persist user | DB technology changes |
| `EmailService` | Send emails | Email provider changes |

## What Counts as "One Responsibility"?

A responsibility is a **reason to change**, which maps to an **actor** (stakeholder) who drives that change:
- Business rules → UserValidator
- DBA / DevOps → UserRepository
- Marketing / UX → EmailService

If two different teams would request changes, those concerns belong in separate classes.

## Pros
- ✅ Easier to understand — each class does one thing
- ✅ Easier to test — focused unit tests with no side-effect coupling
- ✅ Easier to change — modify one concern without fear of breaking others
- ✅ Better reuse — EmailService can be reused across the whole application

## Cons
- ❌ More classes and files to navigate
- ❌ Can be over-applied — splitting too aggressively increases coordination overhead

## When to Use
- When a class grows to handle multiple concerns (God class smell)
- When a change in one area unexpectedly breaks another
- When unit tests require complex mocking due to too many dependencies

## When NOT to Use
- Tiny utility classes that legitimately do one simple thing (no need to split further)
- When splitting would create many anemic data-only classes with no behavior

## Related Principles
- **Open/Closed Principle** — classes focused on one concern are easier to extend
- **Dependency Inversion** — with SRP, each class can depend on abstractions, not concretions
- **Separation of Concerns** — architectural-level version of SRP
