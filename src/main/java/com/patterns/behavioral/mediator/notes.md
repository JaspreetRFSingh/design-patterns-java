# Mediator Pattern

## Overview
The Mediator pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly.

## Problem
Multiple objects communicate directly with each other, creating a complex web of dependencies. Adding or modifying objects requires changes to many other objects.

## Solution
Introduce a mediator object that handles all communication. Objects only communicate with the mediator, not directly with each other.

## Implementation Details

### Key Components
1. **Mediator Interface** (`ChatMediator`) - Defines communication contract
2. **Concrete Mediator** (`ChatRoom`) - Coordinates colleagues
3. **Colleague Interface** (`User`) - Base class for participants
4. **Concrete Colleagues** (`ChatUser`, `AdminUser`) - Participants

### Example: Chat Room
Users don't send messages directly to each other. They send to the `ChatRoom`, which distributes messages to all other users.

```java
// Usage - Users communicate through mediator
User alice = new ChatUser(chatRoom, "Alice");
User bob = new ChatUser(chatRoom, "Bob");

alice.sendMessage("Hello!"); // Goes through chatRoom
// Bob receives: "Hello!"
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Mediator Interface                          │
│                  (ChatMediator)                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + sendMessage(message, user)                        │    │
│  │ + addUser(user)                                     │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│               Concrete Mediator                    │
│                 (ChatRoom)                         │
│  ┌─────────────────────────────────────────────┐  │
│  │ - users: List<User>                         │  │
│  │ + sendMessage() → notifies all users        │  │
│  │ + sendPrivateMessage()                      │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
          ▲                   ▲                   ▲
          │                   │                   │
    ┌─────┴────┐        ┌─────┴────┐        ┌─────┴────┐
    │  User A  │        │  User B  │        │  User C  │
    │(Colleague)│        │(Colleague)│        │(Colleague)│
    └──────────┘        └──────────┘        └──────────┘
          │                   │                   │
          └───────────────────┼───────────────────┘
                              │
                    All communication through
                    ChatRoom (Mediator)
```

## Without Mediator (Tightly Coupled)
```
User A ←→ User B
  ↑ ↓     ↑ ↓
User C ←→ User D

Each user needs references to all others!
```

## With Mediator (Loosely Coupled)
```
User A ─┐
User B ─┼──→ ChatRoom ←── User C
User D ─┘

Each user only knows the mediator!
```

## Pros
- ✅ Single Responsibility Principle - Mediator handles communication
- ✅ Open/Closed Principle - Add new colleagues without changes
- ✅ Reduces coupling between components
- ✅ Simplifies object protocols
- ✅ Centralizes control logic

## Cons
- ❌ Mediator can become a "god object"
- ❌ Single point of failure
- ❌ Can become complex and hard to maintain
- ❌ Additional layer of indirection

## When to Use
- When objects have complex interdependencies
- When you want to reuse objects independently
- When communication protocols are complex
- For distributed systems coordination

## Related Patterns
- **Observer**: Mediator uses observer for notifications
- **Facade**: Both centralize control, different scope
- **Adapter**: Both wrap objects, different purpose
- **Command**: Can encapsulate mediator requests

## Real-World Examples
- Chat rooms, message brokers
- Air traffic control
- Event dispatchers
- Middleware systems
- GUI dialog boxes
