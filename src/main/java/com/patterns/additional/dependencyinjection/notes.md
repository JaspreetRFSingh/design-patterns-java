# Dependency Injection Pattern

## Overview
Dependency Injection (DI) is a technique where objects receive their dependencies from external sources rather than creating them internally. It's a form of Inversion of Control (IoC).

## Problem
Classes create their own dependencies, leading to:
- Tight coupling
- Hard to test (can't mock dependencies)
- Hard to change implementations
- Violation of Single Responsibility Principle

## Solution
Inject dependencies from outside. The class declares what it needs, and an external source provides it.

## Implementation Details

### Key Components
1. **Service Interface** (`MessageService`) - Abstraction
2. **Concrete Services** (`EmailService`, `SMSService`) - Implementations
3. **Client** (`MessageClient`) - Depends on abstraction
4. **Container/Injector** (`ApplicationContainer`) - Wires dependencies

### Example: Message Service
The `MessageClient` needs a `MessageService`. Instead of creating one, it receives it through constructor or setter.

```java
// Without DI (Bad)
public class MessageClient {
    private EmailService service = new EmailService(); // Tight coupling!
}

// With DI (Good)
public class MessageClient {
    private MessageService service;
    
    public MessageClient(MessageService service) { // Injected!
        this.service = service;
    }
}
```

## Types of Injection

### Constructor Injection
```java
public MessageClient(MessageService service) {
    this.service = service;
}
```
- Dependencies are required
- Clear about what's needed
- Immutable dependencies

### Setter Injection
```java
public void setMessageService(MessageService service) {
    this.service = service;
}
```
- Dependencies are optional
- Can change at runtime
- More flexible

### Interface Injection
```java
public interface Injectable {
    void inject(MessageService service);
}
```
- Less common in Java
- More complex

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Service Interface                           │
│                  (MessageService)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + sendMessage(message, recipient)                   │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │  Email  │      │    SMS    │     │  Push   │
   │ Service │      │  Service  │     │ Service │
   └────┬────┘      └─────┬─────┘     └────┬────┘
        │                 │                 │
        └─────────────────┼─────────────────┘
                          │ injected into
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                      Client                                  │
│                  (MessageClient)                             │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - messageService: MessageService                    │    │
│  │ + MessageClient(MessageService) ← Constructor DI    │    │
│  │ + setMessageService(MessageService) ← Setter DI     │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ creates/wires
┌─────────────────────────┴─────────────────────────┐
│                   Container                        │
│            (ApplicationContainer)                  │
│  ┌─────────────────────────────────────────────┐  │
│  │ + create services                           │  │
│  │ + inject dependencies                       │  │
│  │ + manage lifecycle                          │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
```

## Pros
- ✅ Loose coupling
- ✅ Easy to test (mock dependencies)
- ✅ Easy to change implementations
- ✅ Single Responsibility Principle
- ✅ Code is more maintainable

## Cons
- ❌ More configuration needed
- ❌ Can be overkill for simple applications
- ❌ Debugging can be harder
- ❌ Additional framework complexity (if using DI framework)

## When to Use
- For applications with complex dependencies
- When you need to write unit tests
- When implementations may change
- For large, modular applications

## Related Patterns
- **Factory**: Can create dependencies
- **Service Locator**: Alternative to DI
- **Builder**: For complex object creation
- **Singleton**: For shared dependencies

## Real-World Examples
- Spring Framework
- Google Guice
- Dagger (Android)
- ASP.NET Core DI
- Java EE CDI
