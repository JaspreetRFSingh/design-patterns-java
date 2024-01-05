# Singleton Pattern

## Overview
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

## Problem
Some classes should have exactly one instance throughout the application lifetime:
- Configuration manager
- Database connection pool
- Logging system
- Cache system

Creating multiple instances could lead to:
- Inconsistent state
- Resource waste
- Unexpected behavior

## Solution
Make the constructor private and provide a static method to access the single instance.

## Implementation Details

### Key Components
1. **Private constructor** - Prevents external instantiation
2. **Static instance variable** - Holds the single instance
3. **Static accessor method** - Provides global access point
4. **Thread-safe initialization** - Uses double-checked locking

### Example: ConfigManager
The `ConfigManager` class manages application configuration. Only one instance should exist to ensure consistent configuration across the application.

```java
// Usage
ConfigManager config = ConfigManager.getInstance();
config.setConfigData("Production Settings");
```

## Variations

### 1. Eager Initialization
```java
private static final ConfigManager instance = new ConfigManager();
```
- Simple but creates instance even if not used

### 2. Lazy Initialization (Thread-Safe)
```java
public static synchronized ConfigManager getInstance() {
    if (instance == null) {
        instance = new ConfigManager();
    }
    return instance;
}
```
- Thread-safe but slower due to synchronization

### 3. Double-Checked Locking (Used in this example)
```java
public static ConfigManager getInstance() {
    if (instance == null) {
        synchronized (ConfigManager.class) {
            if (instance == null) {
                instance = new ConfigManager();
            }
        }
    }
    return instance;
}
```
- Best of both worlds: lazy + efficient

### 4. Bill Pugh Singleton
```java
private static class SingletonHelper {
    private static final ConfigManager INSTANCE = new ConfigManager();
}
public static ConfigManager getInstance() {
    return SingletonHelper.INSTANCE;
}
```
- Uses class loading mechanism for thread safety

### 5. Enum Singleton (Effective Java recommendation)
```java
public enum ConfigManager {
    INSTANCE;
    // fields and methods
}
```
- Simplest and serialization-safe

## Pros
- ✅ Controlled access to the single instance
- ✅ Reduced memory footprint
- ✅ Prevents concurrent access issues to shared resource

## Cons
- ❌ Violates Single Responsibility Principle
- ❌ Can mask poor design (overuse of globals)
- ❌ Requires special handling in multithreading
- ❌ Makes unit testing harder

## When to Use
- When exactly one instance is required
- For shared resources like configuration
- When lazy initialization is beneficial

## When NOT to Use
- When multiple instances are acceptable
- When the class has significant state that changes frequently
- In favor of dependency
- When testing is a priority (consider dependency injection instead)

## Related Patterns
- **Abstract Factory**: Often implemented as Singleton
- **Facade**: Usually a Singleton
- **State/Strategy**: Objects can be Singletons if stateless
