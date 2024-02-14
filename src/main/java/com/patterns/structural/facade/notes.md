# Facade Pattern

## Overview
The Facade pattern provides a simplified interface to a complex subsystem of classes. It defines a higher-level interface that makes the subsystem easier to use.

## Problem
A subsystem has many classes with complex interactions. Client code needs to understand and manage these complexities, leading to tight coupling and difficult maintenance.

## Solution
Create a facade class that provides a simple interface to the most common subsystem operations. The facade delegates to subsystem classes.

## Implementation Details

### Key Components
1. **Subsystem Classes** (`CPU`, `Memory`, `HardDrive`) - Complex underlying classes
2. **Facade** (`ComputerFacade`) - Simplified interface

### Example: Computer System
Starting a computer involves coordinating CPU, memory, and hard drive. The `ComputerFacade` provides a simple `start()` method that handles all the complexity.

```java
// Usage - Simple interface
ComputerFacade computer = new ComputerFacade();
computer.start();  // One method call vs. many subsystem calls
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                      Facade                                  │
│                 (ComputerFacade)                             │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - cpu: CPU                                          │    │
│  │ - memory: Memory                                    │    │
│  │ - hardDrive: HardDrive                              │    │
│  │ + start()                                           │    │
│  │ + shutdown()                                        │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │ uses
        ┌─────────────────┼─────────────────┐
        │                 │                 │
        ▼                 ▼                 ▼
┌───────────────┐ ┌───────────────┐ ┌───────────────┐
│      CPU      │ │    Memory     │ │  HardDrive    │
├───────────────┤ ├───────────────┤ ├───────────────┤
│ freeze()      │ │ load()        │ │ read()        │
│ jump()        │ │ free()        │ │ getBootSector()│
│ execute()     │ │               │ │               │
└───────────────┘ └───────────────┘ └───────────────┘
```

## Facade with vs without

### Without Facade
```java
// Client must know all subsystem details
CPU cpu = new CPU();
Memory memory = new Memory();
HardDrive hd = new HardDrive();

cpu.freeze();
memory.load(hd.getBootSector(), hd.read(hd.getBootSector(), hd.getSectorSize()));
cpu.jump(0);
cpu.execute();
```

### With Facade
```java
// Simple, clean interface
ComputerFacade computer = new ComputerFacade();
computer.start();
```

## Pros
- ✅ Shields clients from subsystem complexity
- ✅ Promotes loose coupling
- ✅ Single Responsibility Principle - Facade handles subsystem access
- ✅ Easier to use and learn
- ✅ Can layer multiple facades for different use cases

## Cons
- ❌ Can become a "god object" if not designed carefully
- ❌ May limit flexibility (not all subsystem features exposed)
- ❌ Additional layer of indirection

## When to Use
- When you want a simple interface to a complex subsystem
- When there are many dependencies between client and subsystem
- When you want to layer subsystems with facades
- For entry points to complex systems

## Facade vs Other Patterns
| Pattern | Purpose |
|---------|---------|
| Facade | Simplify interface |
| Adapter | Convert interface |
| Mediator | Centralize communication |
| Abstract Factory | Create object families |

## Related Patterns
- **Abstract Factory**: Can be used to create facade's subsystem objects
- **Adapter**: Both wrap other objects, different intent
- **Mediator**: Similar structure, different purpose
- **Singleton**: Facades are often singletons

## Real-World Examples
- SLF4J logging facade
- JDBC (facade over database drivers)
- Spring Framework (facade over JEE)
- API gateways
