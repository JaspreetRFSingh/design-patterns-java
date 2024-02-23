# Proxy Pattern

## Overview
The Proxy pattern provides a surrogate or placeholder for another object to control access to it. It adds a level of indirection to manage how clients interact with the real object.

## Problem
You need to control access to an object for various reasons:
- Lazy loading (expensive object creation)
- Access control (security)
- Logging
- Caching
- Remote access

## Solution
Create a proxy object that implements the same interface as the real object. The proxy controls access and adds additional behavior.

## Implementation Details

### Key Components
1. **Subject** (`Image`) - Common interface
2. **Real Subject** (`RealImage`) - Actual object
3. **Proxy** (`ProxyImage`, `ProtectedImage`) - Controls access

### Example: Image Loading
The `ProxyImage` delays loading the actual image until it's first displayed. This saves resources if the image is never shown.

```java
// Usage - Image not loaded until display() is called
Image image = new ProxyImage("large-photo.jpg");
// ... do other work ...
image.display(); // Now the image loads
```

## Types of Proxies

### Virtual Proxy (Lazy Loading)
```java
public class ProxyImage implements Image {
    private RealImage realImage;
    
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Load on demand
        }
        realImage.display();
    }
}
```

### Protection Proxy (Access Control)
```java
public class ProtectedImage implements Image {
    @Override
    public void display(String userRole) {
        if (hasAccess(userRole)) {
            // Allow access
        } else {
            // Deny access
        }
    }
}
```

### Other Proxy Types
- **Remote Proxy**: Represents objects in different address spaces
- **Caching Proxy**: Caches expensive operations
- **Logging Proxy**: Logs method calls
- **Smart Reference**: Adds additional actions (reference counting, etc.)

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Subject Interface                          │
│                      (Image)                                 │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + display()                                         │    │
│  │ + getFileName()                                     │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│  Real Subject  │                 │     Proxy      │
│  (RealImage)   │                 │  (ProxyImage)  │
├────────────────┤                 ├────────────────┤
│ - fileName     │                 │ - fileName     │
│                │                 │ - realImage    │
├────────────────┤                 ├────────────────┤
│ display()      │                 │ display()      │
│   → loads      │                 │   → delegates  │
│   → displays   │                 │   → adds logic │
└────────────────┘                 └────────────────┘
```

## Pros
- ✅ Controls access to the real object
- ✅ Can add functionality without changing real object
- ✅ Lazy loading improves performance
- ✅ Single Responsibility Principle
- ✅ Open/Closed Principle

## Cons
- ❌ Additional layer of indirection
- ❌ May introduce latency
- ❌ Increased complexity
- ❌ Client may need to know about proxy

## When to Use
- When you need lazy loading for expensive objects
- When you need access control
- When you need logging or monitoring
- When working with remote objects
- When you need caching

## Proxy vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Proxy | Control access |
| Decorator | Add responsibilities |
| Adapter | Convert interface |
| Facade | Simplify interface |

## Related Patterns
- **Decorator**: Both wrap objects, different intent
- **Adapter**: Both wrap objects, different intent
- **Flyweight**: Both can share objects
- **Factory**: Can create proxies

## Real-World Examples
- Java `Proxy` class for dynamic proxies
- Spring AOP proxies
- Hibernate lazy loading
- RPC stubs
- Smart pointers in C++
