# Object Pool Pattern

## Overview
The Object Pool pattern manages a set of reusable objects to avoid the overhead of creating and destroying expensive objects frequently.

## Problem
Creating certain objects is expensive (database connections, threads, network connections). Creating and destroying them frequently impacts performance.

## Solution
Maintain a pool of pre-created objects. When a client needs an object, borrow it from the pool. When done, return it to the pool instead of destroying it.

## Implementation Details

### Key Components
1. **Pooled Object** (`DatabaseConnection`) - Expensive object to reuse
2. **Object Pool** (`ConnectionPool`) - Manages available and in-use objects

### Example: Database Connection Pool
Instead of creating a new database connection for each query, reuse connections from the pool. This significantly improves performance.

```java
// Usage
ConnectionPool pool = new ConnectionPool(10);
DatabaseConnection conn = pool.getConnection(); // Borrow
conn.query("SELECT * FROM users");
pool.releaseConnection(conn); // Return to pool
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                    Object Pool                               │
│                 (ConnectionPool)                             │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - available: List<PooledObject>                     │    │
│  │ - inUse: List<PooledObject>                         │    │
│  │ - maxPoolSize: int                                  │    │
│  │ + getConnection(): PooledObject                     │    │
│  │ + releaseConnection(object)                         │    │
│  │ + shutdown()                                        │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          │ manages
        ┌─────────────────┴─────────────────┐
        │                                   │
        ▼                                   ▼
┌───────────────────┐             ┌───────────────────┐
│    Available      │             │      In Use       │
│    Objects        │             │     Objects       │
│  ┌─────────────┐  │             │  ┌─────────────┐  │
│  │ Connection1 │  │  ← borrow → │  │ Connection3 │  │
│  │ Connection2 │  │             │  │ Connection4 │  │
│  └─────────────┘  │             │  └─────────────┘  │
└───────────────────┘             └───────────────────┘
        ▲                                   │
        │                                   │ return
        └───────────────────────────────────┘
```

## Lifecycle
```
1. Pool initialized (may pre-create objects)
2. Client requests object → getConnection()
3. Pool returns available object or creates new one
4. Client uses object
5. Client returns object → releaseConnection()
6. Object becomes available for reuse
7. On shutdown, all objects are properly destroyed
```

## Pros
- ✅ Improved performance (reuse expensive objects)
- ✅ Controlled resource usage (max pool size)
- ✅ Reduced garbage collection pressure
- ✅ Connection management centralized

## Cons
- ❌ Increased complexity
- ❌ Memory overhead (idle objects)
- ❌ Must ensure objects are properly reset
- ❌ Thread safety concerns

## When to Use
- When object creation is expensive
- When objects are frequently created/destroyed
- When you need to limit resource usage
- For database connections, threads, sockets

## Related Patterns
- **Singleton**: Pool is often a singleton
- **Factory**: Can use factory to create pooled objects
- **Prototype**: Can clone pooled objects

## Real-World Examples
- Database connection pools (HikariCP, DBCP)
- Thread pools (ExecutorService)
- Apache Commons Pool
- HTTP connection pools
