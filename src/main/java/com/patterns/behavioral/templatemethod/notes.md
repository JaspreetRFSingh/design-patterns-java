# Template Method Pattern

## Overview
The Template Method pattern defines the skeleton of an algorithm in a base class but lets subclasses override specific steps without changing the algorithm's structure.

## Problem
Multiple classes have similar algorithms with some varying steps. Duplicating the algorithm leads to code duplication. Changing the algorithm requires changes in multiple places.

## Solution
Define the algorithm skeleton in an abstract base class. Implement common steps in the base class and declare abstract methods for varying steps. Subclasses implement the varying steps.

## Implementation Details

### Key Components
1. **Abstract Class** (`DataParser`) - Defines template method
2. **Template Method** (`parseData()`) - Algorithm skeleton
3. **Concrete Classes** (`CSVParser`, `JSONParser`, `XMLParser`) - Implement specific steps

### Example: Data Parsing
All parsers follow the same steps: open file, extract data, parse, close file, send report. The extraction and parsing logic differs per format.

```java
// Usage - Same algorithm, different implementations
DataParser parser = new JSONParser();
parser.parseData("data.json"); // Uses template method
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                  Abstract Class                              │
│                   (DataParser)                               │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + parseData(filePath) [FINAL] ← Template Method     │    │
│  │   → openFile()                                      │    │
│  │   → extractData() [ABSTRACT]                        │    │
│  │   → parseData() [ABSTRACT]                          │    │
│  │   → closeFile()                                     │    │
│  │   → sendReport() [ABSTRACT]                         │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │  CSV    │      │   JSON    │     │   XML   │
   │ Parser  │      │  Parser   │     │ Parser  │
   ├─────────┤      ├───────────┤     ├─────────┤
   │extract()│      │ extract() │     │extract()│
   │parse()  │      │ parse()   │     │parse()  │
   │report() │      │ report()  │     │report() │
   └─────────┘      └───────────┘     └─────────┘
```

## Hook Methods
```java
// Optional step with default implementation
protected boolean shouldSendReport() {
    return true; // Default behavior
}

// Subclass can override
@Override
protected boolean shouldSendReport() {
    return false; // Skip report
}
```

## Pros
- ✅ Code reuse - Common code in base class
- ✅ Single Responsibility Principle - Each class has one job
- ✅ Open/Closed Principle - Add new implementations without changing template
- ✅ Inversion of Control - "Hollywood Principle": Don't call us, we'll call you

## Cons
- ❌ Can lead to many subclasses
- ❌ May be inflexible for complex variations
- ❌ Violates Liskov if subclasses can't follow template

## When to Use
- When you have a fixed algorithm with varying steps
- When you want to avoid code duplication
- When you want to control extension points
- For framework development

## Template Method vs Strategy
| Template Method | Strategy |
|-----------------|----------|
| Inheritance-based | Composition-based |
| Algorithm fixed | Algorithm interchangeable |
| Harder to change | Easier to change |

## Related Patterns
- **Factory Method**: Often used in template methods
- **Strategy**: Alternative using composition
- **Hook**: Optional steps in template

## Real-World Examples
- Java `AbstractList`, `AbstractSet`
- Servlet `doGet()`, `doPost()`
- JUnit test framework
- Build tools (Maven, Gradle)
- Spring's `JdbcTemplate`
