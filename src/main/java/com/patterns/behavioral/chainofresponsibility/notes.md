# Chain of Responsibility Pattern

## Overview
The Chain of Responsibility pattern passes requests along a chain of handlers. Each handler decides whether to process the request or pass it to the next handler.

## Problem
Multiple objects can handle a request, but the sender shouldn't know which one. Hard-coding the handler creates tight coupling.

## Solution
Create a chain of handler objects. Each handler either processes the request or passes it to the next handler in the chain.

## Implementation Details

### Key Components
1. **Handler Interface** (`SupportHandler`) - Defines handling contract
2. **Concrete Handlers** (`Level1Support`, `Level2Support`, etc.) - Process or forward
3. **Request** (`SupportRequest`) - Data being passed
4. **Client** - Builds the chain and initiates requests

### Example: Support Ticket System
Support tickets are handled based on priority. Level 1 handles simple issues, escalating complex issues up the chain.

```java
// Build chain
level1.setNextHandler(level2);
level2.setNextHandler(level3);

// Send request - sender doesn't know who handles it
level1.handleRequest(new SupportRequest("Issue", priority));
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                   Handler Interface                          │
│                  (SupportHandler)                            │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + handleRequest(request)                            │    │
│  │ + setNextHandler(handler)                           │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
                          │ implements
┌─────────────────────────┴─────────────────────────┐
│               Abstract Handler                     │
│          (AbstractSupportHandler)                  │
│  ┌─────────────────────────────────────────────┐  │
│  │ - nextHandler: SupportHandler               │  │
│  │ + handleRequest() → delegates or forwards   │  │
│  └─────────────────────────────────────────────┘  │
└───────────────────────────────────────────────────┘
                          ▲
        ┌────────┬────────┼────────┬────────┐
        │        │        │        │        │
   ┌────▼───┐ ┌──▼────┐ ┌─▼────┐ ┌─▼────┐ ┌─▼────┐
   │ Level1 │ │Level2 │ │Level3│ │Manager│ │ ...  │
   │Support │ │Support│ │Support│ │Support│       │
   └────────┘ └───────┘ └──────┘ └───────┘ └──────┘

Chain: Level1 → Level2 → Level3 → Manager
```

## Request Flow
```
Request (Priority 2)
    ↓
Level1 Support (handles 1) → Can't handle, forward
    ↓
Level2 Support (handles 2) → Handles! ✓
```

## Pros
- ✅ Decouples sender from receiver
- ✅ Single Responsibility Principle - Each handler has one job
- ✅ Open/Closed Principle - Add new handlers without changing existing code
- ✅ Flexible chain configuration
- ✅ Dynamic chain modification at runtime

## Cons
- ❌ Request may go unhandled
- ❌ Can be slow with long chains
- ❌ Hard to debug (unclear who handled)
- ❌ Circular references possible

## When to Use
- When multiple objects can handle a request
- When the handler should be determined dynamically
- When you want to decouple sender and receiver
- For event handling systems
- For approval workflows

## Related Patterns
- **Command**: Can encapsulate requests
- **Composite**: Can represent chain as tree
- **Observer**: Both pass objects between objects
- **Strategy**: Both delegate work

## Real-World Examples
- Java Servlet Filters
- Logging frameworks (log levels)
- Exception handling
- Middleware in web frameworks
- Approval workflows
