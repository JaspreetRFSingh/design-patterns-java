# Design Patterns in Java

A comprehensive collection of all classic design patterns implemented in Java.

## Patterns Included

### Creational Patterns
- **[Singleton](src/main/java/com/patterns/creational/singleton/notes.md)** - Ensures a class has only one instance
- **[Factory Method](src/main/java/com/patterns/creational/factory/notes.md)** - Creates objects without specifying exact class
- **[Abstract Factory](src/main/java/com/patterns/creational/abstractfactory/notes.md)** - Creates families of related objects
- **[Builder](src/main/java/com/patterns/creational/builder/notes.md)** - Constructs complex objects step by step
- **[Prototype](src/main/java/com/patterns/creational/prototype/notes.md)** - Creates objects by cloning existing ones

### Structural Patterns
- **[Adapter](src/main/java/com/patterns/structural/adapter/notes.md)** - Makes incompatible interfaces work together
- **[Bridge](src/main/java/com/patterns/structural/bridge/notes.md)** - Separates abstraction from implementation
- **[Composite](src/main/java/com/patterns/structural/composite/notes.md)** - Treats individual objects and compositions uniformly
- **[Decorator](src/main/java/com/patterns/structural/decorator/notes.md)** - Adds behavior to objects dynamically
- **[Facade](src/main/java/com/patterns/structural/facade/notes.md)** - Provides simplified interface to a complex subsystem
- **[Flyweight](src/main/java/com/patterns/structural/flyweight/notes.md)** - Minimizes memory usage by sharing data
- **[Proxy](src/main/java/com/patterns/structural/proxy/notes.md)** - Controls access to an object

### Behavioral Patterns
- **[Chain of Responsibility](src/main/java/com/patterns/behavioral/chainofresponsibility/notes.md)** - Passes requests along a chain of handlers
- **[Command](src/main/java/com/patterns/behavioral/command/notes.md)** - Encapsulates requests as objects
- **[Interpreter](src/main/java/com/patterns/behavioral/interpreter/notes.md)** - Defines grammar and interprets sentences
- **[Iterator](src/main/java/com/patterns/behavioral/iterator/notes.md)** - Provides sequential access to aggregate elements
- **[Mediator](src/main/java/com/patterns/behavioral/mediator/notes.md)** - Centralizes complex communications
- **[Memento](src/main/java/com/patterns/behavioral/memento/notes.md)** - Captures and restores object state
- **[Observer](src/main/java/com/patterns/behavioral/observer/notes.md)** - Notifies dependents of state changes
- **[State](src/main/java/com/patterns/behavioral/state/notes.md)** - Allows objects to change behavior based on state
- **[Strategy](src/main/java/com/patterns/behavioral/strategy/notes.md)** - Defines interchangeable algorithms
- **[Template Method](src/main/java/com/patterns/behavioral/templatemethod/notes.md)** - Defines skeleton of an algorithm
- **[Visitor](src/main/java/com/patterns/behavioral/visitor/notes.md)** - Separates algorithm from object structure

### Additional Patterns
- **[Null Object](src/main/java/com/patterns/additional/nullobject/notes.md)** - Provides neutral default behavior
- **[Object Pool](src/main/java/com/patterns/additional/objectpool/notes.md)** - Reuses expensive objects
- **[MVC](src/main/java/com/patterns/additional/mvc/notes.md)** - Separates concerns into Model, View, Controller
- **[Dependency Injection](src/main/java/com/patterns/additional/dependencyinjection/notes.md)** - Inverts control of dependencies

## Design Principles

### SOLID Principles
- **[Single Responsibility (SRP)](src/main/java/com/patterns/principles/solid/srp/notes.md)** - A class should have only one reason to change
- **[Open/Closed (OCP)](src/main/java/com/patterns/principles/solid/ocp/notes.md)** - Open for extension, closed for modification
- **[Liskov Substitution (LSP)](src/main/java/com/patterns/principles/solid/lsp/notes.md)** - Subtypes must be substitutable for their base types
- **[Interface Segregation (ISP)](src/main/java/com/patterns/principles/solid/isp/notes.md)** - Clients should not depend on interfaces they don't use
- **[Dependency Inversion (DIP)](src/main/java/com/patterns/principles/solid/dip/notes.md)** - Depend on abstractions, not concretions

### General Principles
- **[DRY](src/main/java/com/patterns/principles/dry/notes.md)** - Don't Repeat Yourself — every piece of knowledge has one authoritative representation
- **[KISS](src/main/java/com/patterns/principles/kiss/notes.md)** - Keep It Simple, Stupid — avoid unnecessary complexity
- **[YAGNI](src/main/java/com/patterns/principles/yagni/notes.md)** - You Aren't Gonna Need It — don't implement until actually needed
- **[Law of Demeter](src/main/java/com/patterns/principles/lod/notes.md)** - Only talk to your immediate friends
- **[Composition over Inheritance](src/main/java/com/patterns/principles/compositionoverinheritance/notes.md)** - Favour object composition over class inheritance

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
├── additional/
│   ├── nullobject/
│   ├── objectpool/
│   ├── mvc/
│   └── dependencyinjection/
└── principles/
    ├── solid/
    │   ├── srp/
    │   ├── ocp/
    │   ├── lsp/
    │   ├── isp/
    │   └── dip/
    ├── dry/
    ├── kiss/
    ├── yagni/
    ├── lod/
    └── compositionoverinheritance/
```
