# Adapter Pattern

## Overview
The Adapter pattern allows incompatible interfaces to work together. It acts as a wrapper between two incompatible interfaces.

## Problem
You have existing code that expects a specific interface, but you need to use a class with a different interface. You cannot modify the existing classes.

## Solution
Create an adapter class that implements the expected interface and translates calls to the adaptee's interface.

## Implementation Details

### Key Components
1. **Target** (`PaymentProcessor`) - Interface the client expects
2. **Adaptee** (`PayPalService`, `StripeService`) - Existing incompatible interface
3. **Adapter** (`PayPalAdapter`, `StripeAdapter`) - Translates between interfaces

### Example: Payment Processing
The application uses `PaymentProcessor` interface, but third-party services (PayPal, Stripe) have different APIs. Adapters bridge the gap.

```java
// Client code - works with any PaymentProcessor
PaymentProcessor processor = new PayPalAdapter(new PayPalService());
processor.processPayment(99.99);
```

## Types of Adapters

### Object Adapter (Composition - Used here)
```java
public class PayPalAdapter implements PaymentProcessor {
    private PayPalService payPalService; // Composition
    // ...
}
```

### Class Adapter (Multiple Inheritance)
```java
public class PayPalAdapter extends PayPalService implements PaymentProcessor {
    // Inherits from PayPalService, implements PaymentProcessor
}
```
- Not possible in Java (no multiple inheritance for classes)

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                    Target Interface                          │
│                  (PaymentProcessor)                          │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + processPayment(amount: double)                    │    │
│  │ + refund(amount: double)                            │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│                     Adapter                        │
│                (PayPalAdapter)                     │
│  ┌─────────────────────────────────────────────┐  │
│  │ - payPalService: PayPalService              │  │
│  │ + processPayment() → sendPayment()          │  │
│  │ + refund() → receiveRefund()                │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          │ uses
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                      Adaptee                                 │
│                   (PayPalService)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + sendPayment(amount: double)                       │    │
│  │ + receiveRefund(amount: double)                     │    │
│  │ + authenticate()                                    │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

## Pros
- ✅ Single Responsibility Principle - Separates interface conversion from business logic
- ✅ Open/Closed Principle - Add new adapters without changing existing code
- ✅ Allows reuse of existing classes
- ✅ Client code remains simple and decoupled

## Cons
- ❌ Increased complexity with multiple adapters
- ❌ May require multiple adapters for different implementations
- ❌ Can lead to many small adapter classes

## When to Use
- When you need to use an existing class with incompatible interface
- When you want to create a reusable class that works with unrelated classes
- When integrating third-party libraries or legacy code
- When multiple objects need a unified interface

## Real-World Examples
- Java `InputStreamReader` (adapts InputStream to Reader)
- Java `Arrays.asList()` (adapts array to List)
- Spring `HandlerAdapter` (adapts different handler types)
- JDBC drivers (adapt database-specific APIs)

## Related Patterns
- **Bridge**: Similar structure but different intent
- **Decorator**: Adds behavior, Adapter changes interface
- **Facade**: Simplifies interface, Adapter converts interface
- **Proxy**: Controls access, Adapter converts interface
