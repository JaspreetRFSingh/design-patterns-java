# Command Pattern

## Overview
The Command pattern encapsulates a request as an object, allowing you to parameterize clients with different requests, queue requests, or log operations. It also supports undoable operations.

## Problem
You need to:
- Queue or schedule requests
- Support undo/redo operations
- Log all requests
- Create macros (composite commands)
- Decouple sender from receiver

## Solution
Encapsulate each request as a command object with `execute()` and `undo()` methods. The invoker executes commands without knowing the details.

## Implementation Details

### Key Components
1. **Command Interface** (`Command`) - Declares execute/undo
2. **Concrete Commands** (`LightOnCommand`, `TVOffCommand`, etc.) - Implement actions
3. **Receiver** (`Light`, `TV`) - Performs the actual work
4. **Invoker** (`RemoteControl`) - Triggers command execution

### Example: Universal Remote
The remote control stores commands and executes them when buttons are pressed. It doesn't know what device it controls.

```java
// Usage
Command lightOn = new LightOnCommand(light);
remote.addCommand(lightOn);
remote.pressButton(0); // Executes lightOn
remote.pressUndo();    // Undoes the action
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Command Interface                          │
│                      (Command)                               │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + execute()                                         │    │
│  │ + undo()                                            │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │LightOn  │      │LightOff   │     │  TVOn   │
   │ Command │      │ Command   │     │ Command │
   └────┬────┘      └─────┬─────┘     └────┬────┘
        │                 │                 │
        │ uses            │ uses            │ uses
        ▼                 ▼                 ▼
┌───────────────┐ ┌───────────────┐ ┌───────────────┐
│     Light     │ │     Light     │ │      TV       │
│   (Receiver)  │ │   (Receiver)  │ │   (Receiver)  │
└───────────────┘ └───────────────┘ └───────────────┘

┌─────────────────────────────────────────────────────────────┐
│                     Invoker                                  │
│                  (RemoteControl)                             │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - commands: List<Command>                           │    │
│  │ - history: Stack<Command>                           │    │
│  │ + pressButton(slot)                                 │    │
│  │ + pressUndo()                                       │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

## Pros
- ✅ Single Responsibility Principle - Commands encapsulate single actions
- ✅ Open/Closed Principle - Add new commands without changing invoker
- ✅ Undo/Redo support
- ✅ Command queuing and scheduling
- ✅ Decouples invoker from receiver
- ✅ Macro commands (composite commands)

## Cons
- ❌ Increased number of classes
- ❌ Can be overkill for simple operations
- ❌ More complex code structure

## When to Use
- When you need undo/redo functionality
- When you need to queue or schedule operations
- When you want to log all operations
- When you need to decouple sender from receiver
- For transactional operations

## Related Patterns
- **Composite**: For macro commands
- **Memento**: For storing command state
- **Prototype**: For cloning commands
- **Strategy**: Similar structure, different intent

## Real-World Examples
- Text editor operations (undo/redo)
- Task queues (JMS, RabbitMQ)
- Macro recording
- Transaction management
- GUI event handling
