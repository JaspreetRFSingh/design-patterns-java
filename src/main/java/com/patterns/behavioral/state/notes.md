# State Pattern

## Overview
The State pattern allows an object to alter its behavior when its internal state changes. The object appears to change its class.

## Problem
An object's behavior depends on its state, and it must change behavior at runtime based on that state. Using conditionals leads to complex, hard-to-maintain code.

## Solution
Define state objects for each state. The context delegates behavior to the current state object. Changing state means changing the delegated object.

## Implementation Details

### Key Components
1. **State Interface** (`State`) - Defines behavior for each state
2. **Concrete States** (`NoQuarterState`, `HasQuarterState`, etc.) - Implement state-specific behavior
3. **Context** (`VendingMachine`) - Maintains current state

### Example: Vending Machine
The vending machine has different states (no money, has money, dispensing, sold out). Each state handles actions differently.

```java
// Usage
machine.insertDollar();  // Behavior depends on current state
machine.dispense();      // Different in each state
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                    State Interface                           │
│                      (State)                                 │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + insertDollar(context)                             │    │
│  │ + ejectMoney(context)                               │    │
│  │ + dispense(context)                                 │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌────────┬────────┼────────┬────────┐
        │        │        │        │        │
   ┌────▼───┐ ┌──▼────┐ ┌─▼────┐ ┌─▼────┐ ┌─▼────┐
   │NoQuarter│ │HasQuar│ │ Sold │ │SoldOut│ │ ...  │
   │  State  │ │terState│ │State │ │ State │       │
   └────┬───┘ └───┬───┘ └──┬───┘ └───┬───┘ └──────┘
        │          │         │         │
        └──────────┴────┬────┴─────────┘
                        │
                        │ uses
                        ▼
┌─────────────────────────────────────────────────────────────┐
│                     Context                                  │
│                  (VendingMachine)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - currentState: State                               │    │
│  │ - states: [NoQuarter, HasQuarter, Sold, SoldOut]    │    │
│  │ + insertDollar() → currentState.insertDollar(this)  │    │
│  │ + dispense() → currentState.dispense(this)          │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

## State Transitions
```
                    insertDollar()
NoQuarterState ──────────────────→ HasQuarterState
     ↑                                   │
     │ ejectMoney()                      │ dispense()
     │                                   ▼
     │                              SoldState
     │                                   │
     │         count > 0                 │ releaseBall()
     └───────────────────────────────────┘
                                        │
                              count == 0│
                                        ▼
                                   SoldOutState
```

## State vs Strategy
| State | Strategy |
|-------|----------|
| State changes automatically | Strategy chosen by client |
| States know about each other | Strategies are independent |
| Behavior changes with state | Algorithm changes with strategy |

## Pros
- ✅ Single Responsibility Principle - Each state has one job
- ✅ Open/Closed Principle - Add new states without changing context
- ✅ Eliminates complex conditionals
- ✅ Makes state transitions explicit

## Cons
- ❌ Can have many state classes
- ❌ States may be tightly coupled
- ❌ Can be overkill for simple state machines

## When to Use
- When behavior changes based on state
- When you have many conditionals based on state
- When state transitions are complex
- For finite state machines

## Related Patterns
- **Strategy**: Similar structure, different intent
- **State Machine**: State is part of state machine
- **Singleton**: States can be singletons
- **Flyweight**: Share state objects

## Real-World Examples
- Workflow systems
- Game character states
- TCP connection states
- Order processing
- UI component states
