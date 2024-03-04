# Interpreter Pattern

## Overview
The Interpreter pattern defines a grammar for a language and provides an interpreter to interpret sentences in that language. It uses a class hierarchy to represent grammar rules.

## Problem
You need to interpret sentences in a simple language. The language has a grammar that can be represented as an abstract syntax tree (AST).

## Solution
Represent each grammar rule as a class. Terminal expressions represent basic tokens, while non-terminal expressions represent combinations of rules.

## Implementation Details

### Key Components
1. **Abstract Expression** (`Expression`) - Interface for interpretation
2. **Terminal Expression** (`TerminalExpression`) - Basic tokens/words
3. **Non-Terminal Expression** (`OrExpression`, `AndExpression`) - Grammar rules
4. **Context** - The input being interpreted

### Example: Text Filter
Build expression trees to match text patterns. Combine simple rules using AND/OR operations.

```java
// Build grammar rule: "Java" OR "Python"
Expression rule = new OrExpression(
    new TerminalExpression("Java"),
    new TerminalExpression("Python")
);

// Interpret sentence
boolean matches = rule.interpret("I love Java"); // true
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                Abstract Expression                           │
│                   (Expression)                               │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ + interpret(context): boolean                       │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
                          ▲
        ┌─────────────────┼─────────────────┐
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │Terminal │      │    Or     │     │   And   │
   │Expression│     │ Expression│     │Expression│
   └────┬────┘      └─────┬─────┘     └────┬────┘
        │                 │                 │
        │                 │                 │
   ┌────▼────┐      ┌─────▼─────┐     ┌────▼────┐
   │  data   │      │ expr1,    │     │ expr1,  │
   │ (word)  │      │  expr2    │     │  expr2  │
   └─────────┘      └───────────┘     └─────────┘
```

## Expression Tree Example
```
Rule: (Java OR Python) AND Programming

              AND
             /   \
           OR     "Programming"
          /  \
    "Java"    "Python"

Interpret "Java Programming":
  - "Java" → true
  - "Python" → false
  - OR → true
  - "Programming" → true
  - AND → true ✓
```

## Pros
- ✅ Easy to change or extend grammar
- ✅ Easy to add new expressions
- ✅ Good for simple grammars
- ✅ Grammar rules are encapsulated in classes

## Cons
- ❌ Complex for large grammars
- ❌ Many classes for complex grammars
- ❌ Can be slow for complex expressions
- ❌ Difficult to maintain for complex languages

## When to Use
- When you have a simple language to interpret
- When grammar is simple and stable
- When efficiency is not critical
- For rule engines, query languages, filters

## When NOT to Use
- For complex grammars (use parser generators)
- When performance is critical
- When the grammar changes frequently

## Related Patterns
- **Composite**: Expression trees are composites
- **Flyweight**: Share terminal expressions
- **Iterator**: Traverse expression trees
- **Visitor**: Perform operations on AST

## Real-World Examples
- SQL query parsers
- Regular expression engines
- Compiler interpreters
- Rule engines
- Template engines
