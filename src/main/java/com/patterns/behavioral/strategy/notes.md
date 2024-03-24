# Strategy Pattern

## Overview
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from the clients that use it.

## Problem
You have multiple algorithms for the same task. Using conditionals to select algorithms leads to complex, hard-to-maintain code. Adding new algorithms requires changing existing code.

## Solution
Define each algorithm as a separate class implementing a common interface. The context uses a strategy object and can switch strategies at runtime.

## Implementation Details

### Key Components
1. **Strategy Interface** (`PaymentStrategy`) - Common interface
2. **Concrete Strategies** (`CreditCardPayment`, `PayPalPayment`, `BitcoinPayment`)
3. **Context** (`ShoppingCart`) - Uses strategy

### Example: Payment Processing
The shopping cart can use different payment methods. The payment strategy can be changed at runtime without modifying the cart.

```java
// Usage
cart.setPaymentStrategy(new CreditCardPayment(...));
cart.checkout();

cart.setPaymentStrategy(new PayPalPayment(...));
cart.checkout();
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Strategy Interface                          │
│                 (PaymentStrategy)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + pay(amount: double)                               │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │CreditCard│     │  PayPal   │     │ Bitcoin │
   │ Payment  │     │  Payment  │     │ Payment │
   └────┬────┘      └─────┬─────┘     └────┬────┘
        │                 │                 │
        └─────────────────┼─────────────────┘
                          │
                          │ uses
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                     Context                                  │
│                  (ShoppingCart)                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - paymentStrategy: PaymentStrategy                  │    │
│  │ - total: double                                     │    │
│  │ + setPaymentStrategy(strategy)                      │    │
│  │ + checkout() → strategy.pay(total)                  │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

## Without Strategy
```java
public void checkout(String paymentType) {
    if (paymentType.equals("credit")) {
        // Credit card logic
    } else if (paymentType.equals("paypal")) {
        // PayPal logic
    } else if (paymentType.equals("bitcoin")) {
        // Bitcoin logic
    }
}
```

## With Strategy
```java
public void checkout() {
    paymentStrategy.pay(total); // Clean delegation
}
```

## Pros
- ✅ Open/Closed Principle - Add strategies without changing context
- ✅ Single Responsibility Principle - Each strategy has one job
- ✅ Avoids complex conditionals
- ✅ Runtime strategy selection
- ✅ Easy to test strategies independently

## Cons
- ❌ Increased number of classes
- ❌ Client must know about strategies
- ❌ Strategies may expose internal state

## When to Use
- When you have multiple algorithms for the same task
- When you need to avoid complex conditionals
- When algorithms need to be selected at runtime
- When algorithm variants have different implementations

## Strategy vs State
| Strategy | State |
|----------|-------|
| Client chooses strategy | State changes automatically |
| Strategies independent | States know about each other |
| For interchangeable algorithms | For state-dependent behavior |

## Related Patterns
- **State**: Similar structure, different intent
- **Bridge**: Both use composition for variation
- **Factory**: Can create strategies
- **Template Method**: Alternative using inheritance

## Real-World Examples
- Sorting algorithms (Comparator)
- Compression algorithms
- Payment methods
- Navigation algorithms (GPS)
- File export formats
