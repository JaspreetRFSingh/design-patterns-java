# Bridge Pattern

## Overview
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently.

## Problem
When a class has multiple dimensions of variation (e.g., different types of remotes AND different types of devices), using inheritance leads to class explosion.

## Solution
Separate the abstraction (remote control) from the implementation (device) using composition. Both can evolve independently.

## Implementation Details

### Key Components
1. **Implementor** (`Device`) - Interface for implementations
2. **Concrete Implementors** (`TV`, `Radio`) - Actual implementations
3. **Abstraction** (`RemoteControl`) - Maintains reference to implementor
4. **Refined Abstraction** (`AdvancedRemoteControl`) - Extends abstraction

### Example: Remote Control System
The `RemoteControl` abstraction can work with any `Device`. Adding a new device doesn't require new remote classes, and adding new remote features doesn't require device changes.

```java
// Usage
Device tv = new TV();
RemoteControl remote = new AdvancedRemoteControl(tv);
remote.togglePower();
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Abstraction                                │
│                  (RemoteControl)                             │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - device: Device                                    │    │
│  │ + togglePower()                                     │    │
│  │ + volumeUp()                                        │    │
│  │ + volumeDown()                                      │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ extends
┌─────────────────────────┴─────────────────────────┐
│              Refined Abstraction                   │
│           (AdvancedRemoteControl)                  │
│  ┌─────────────────────────────────────────────┐  │
│  │ + setChannel()                              │  │
│  │ + setFrequency()                            │  │
│  │ + printStatus()                             │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          │
                          │ has-a
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                   Implementor                                │
│                      (Device)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + turnOn()                                          │    │
│  │ + turnOff()                                         │    │
│  │ + setVolume()                                       │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┴─────────────────┐
        │                                   │
┌───────▼────────┐                 ┌────────▼───────┐
│       TV       │                 │     Radio      │
└────────────────┘                 └────────────────┘
```

## Bridge vs Inheritance

### Without Bridge (Class Explosion)
```
TVRemoteControl
RadioRemoteControl
AdvancedTVRemoteControl
AdvancedRadioRemoteControl
UniversalTVRemoteControl
UniversalRadioRemoteControl
...
```

### With Bridge (Composable)
```
Remote Controls: Basic, Advanced, Universal
Devices: TV, Radio, DVD, AC
Total: 2 classes + N device classes
```

## Pros
- ✅ Decouples abstraction from implementation
- ✅ Open/Closed Principle - Extend both independently
- ✅ Single Responsibility Principle - Separate concerns
- ✅ Avoids class explosion
- ✅ Client code shielded from implementation changes

## Cons
- ❌ Increased complexity
- ❌ May be overkill for simple hierarchies
- ❌ Requires careful design of abstraction/implementation split

## When to Use
- When you want to avoid permanent binding between abstraction and implementation
- When both abstraction and implementation should be extensible
- When changes in implementation shouldn't affect client code
- When you have multiple independent dimensions of variation

## Bridge vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Bridge | Decouple abstraction from implementation |
| Adapter | Make incompatible interfaces work together |
| Strategy | Interchangeable algorithms |
| State | Behavior changes with internal state |

## Related Patterns
- **Abstract Factory**: Can create bridge implementations
- **Adapter**: Both use composition, different intent
- **Strategy**: Similar structure, different intent
- **State**: Can use Bridge for state implementations
