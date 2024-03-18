# Observer Pattern

## Overview
The Observer pattern defines a one-to-many dependency between objects. When one object (subject) changes state, all its dependents (observers) are notified and updated automatically.

## Problem
Multiple objects need to react to state changes in another object. Hard-coding these relationships creates tight coupling and makes it hard to add/remove observers.

## Solution
Define a subscription mechanism. Observers subscribe to the subject and receive notifications when the subject's state changes.

## Implementation Details

### Key Components
1. **Subject Interface** (`Subject`) - Attach/detach/notify
2. **Concrete Subject** (`NewsAgency`) - Maintains observer list
3. **Observer Interface** (`Observer`) - Update method
4. **Concrete Observers** (`TVChannel`, `NewsPortal`, `MobileApp`)

### Example: News Agency
The `NewsAgency` maintains a list of subscribers. When news is published, all subscribers are notified automatically.

```java
// Usage
newsAgency.attach(new TVChannel("CNN"));
newsAgency.attach(new NewsPortal("Reuters"));
newsAgency.setNews("Breaking news!"); // All observers notified
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Subject Interface                          │
│                     (Subject)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + attach(observer)                                  │    │
│  │ + detach(observer)                                  │    │
│  │ + notifyObservers()                                 │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│                Concrete Subject                    │
│                 (NewsAgency)                       │
│  ┌─────────────────────────────────────────────┐  │
│  │ - observers: List<Observer>                 │  │
│  │ - state: String                             │  │
│  │ + attach() / detach()                       │  │
│  │ + notifyObservers()                         │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          │ notifies
        ┌─────────────────┼─────────────────┐
        │                 │                 │
        ▼                 ▼                 ▼
┌───────────────┐ ┌───────────────┐ ┌───────────────┐
│   TVChannel   │ │  NewsPortal   │ │   MobileApp   │
│  (Observer)   │ │  (Observer)   │ │  (Observer)   │
└───────────────┘ └───────────────┘ └───────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│                  Observer Interface                │
│                    (Observer)                      │
│  ┌─────────────────────────────────────────────┐  │
│  │ + update(message)                           │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
```

## Push vs Pull Model

### Push Model (Used here)
```java
public void update(String message) {
    // Data pushed to observer
}
```

### Pull Model
```java
public void update() {
    // Observer pulls data from subject
    String news = subject.getNews();
}
```

## Pros
- ✅ Open/Closed Principle - Add observers without changing subject
- ✅ Loose coupling between subject and observers
- ✅ Supports broadcast communication
- ✅ Observer relationships at runtime

## Cons
- ❌ No guarantee of notification order
- ❌ Memory leaks if not properly detached
- ❌ Unexpected updates can be confusing
- ❌ Can cause cascading updates

## When to Use
- When changes to one object affect many others
- When objects should notify without knowing recipients
- For event handling systems
- For distributed event systems

## Related Patterns
- **Mediator**: Encapsulates complex relationships
- **Memento**: Can store observer state
- **Strategy**: Similar structure, different intent
- **Singleton**: Subjects are often singletons

## Real-World Examples
- Event listeners in GUI frameworks
- Pub/Sub systems
- RSS feeds
- Reactive programming (RxJava)
- MVC pattern (Model notifies View)
