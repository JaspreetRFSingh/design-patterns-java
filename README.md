# Design Patterns in Java

A comprehensive collection of all classic design patterns implemented in Java.

## Patterns Included

### Creational Patterns
- **Singleton** - Ensures a class has only one instance
- **Factory Method** - Creates objects without specifying exact class
- **Abstract Factory** - Creates families of related objects
- **Builder** - Constructs complex objects step by step
- **Prototype** - Creates objects by cloning existing ones

### Structural Patterns
- **Adapter** - Makes incompatible interfaces work together
- **Bridge** - Separates abstraction from implementation
- **Composite** - Treats individual objects and compositions uniformly
- **Decorator** - Adds behavior to objects dynamically
- **Facade** - Provides simplified interface to a complex subsystem
- **Flyweight** - Minimizes memory usage by sharing data
- **Proxy** - Controls access to an object

### Behavioral Patterns
- **Chain of Responsibility** - Passes requests along a chain of handlers
- **Command** - Encapsulates requests as objects
- **Interpreter** - Defines grammar and interprets sentences
- **Iterator** - Provides sequential access to aggregate elements
- **Mediator** - Centralizes complex communications
- **Memento** - Captures and restores object state
- **Observer** - Notifies dependents of state changes
- **State** - Allows objects to change behavior based on state
- **Strategy** - Defines interchangeable algorithms
- **Template Method** - Defines skeleton of an algorithm
- **Visitor** - Separates algorithm from object structure

### Additional Patterns
- **Null Object** - Provides neutral default behavior
- **Object Pool** - Reuses expensive objects
- **MVC** - Separates concerns into Model, View, Controller
- **Dependency Injection** - Inverts control of dependencies

## Building

```bash
mvn compile
```

## Running Examples

Each pattern has a Demo class that demonstrates its usage:

```bash
java -cp target/classes com.patterns.creational.singleton.SingletonDemo
```

## Structure

```
src/main/java/com/patterns/
├── creational/
│   ├── singleton/
│   ├── factory/
│   ├── abstractfactory/
│   ├── builder/
│   └── prototype/
├── structural/
│   ├── adapter/
│   ├── bridge/
│   ├── composite/
│   ├── decorator/
│   ├── facade/
│   ├── flyweight/
│   └── proxy/
├── behavioral/
│   ├── chainofresponsibility/
│   ├── command/
│   ├── interpreter/
│   ├── iterator/
│   ├── mediator/
│   ├── memento/
│   ├── observer/
│   ├── state/
│   ├── strategy/
│   ├── templatemethod/
│   └── visitor/
└── additional/
    ├── nullobject/
    ├── objectpool/
    ├── mvc/
    └── dependencyinjection/
```
