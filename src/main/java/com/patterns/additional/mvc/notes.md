# MVC Pattern

## Overview
The MVC (Model-View-Controller) pattern separates an application into three interconnected components: Model (data), View (presentation), and Controller (input handling).

## Problem
Applications mix data, presentation, and business logic, making code hard to maintain, test, and modify. Changing the UI requires changing business logic.

## Solution
Separate concerns into three components:
- **Model**: Data and business logic
- **View**: Presentation layer
- **Controller**: Handles input, updates model

## Implementation Details

### Key Components
1. **Model** (`Student`) - Data and business logic with observer support
2. **View** (`StudentView`, `JsonStudentView`) - Displays data
3. **Controller** (`StudentController`) - Handles input, updates model

### Example: Student Management
The `Student` model holds data and notifies observers when changed. Views display the data. Controller handles user input.

```java
// Usage
Student student = new Student("S001", "John", "A");
StudentView view = new StudentView();
StudentController controller = new StudentController(student, view);

controller.setStudentName("Jane"); // Updates model, notifies view
```

## Structure
```
┌─────────────────────────────────────────────────────────────┐
│                      Model                                   │
│                     (Student)                                │
│  ┌─────────────────────────────────────────────────────┐    │
│  │ - id, name, grade                                   │    │
│  │ - observers: List<Observer>                         │    │
│  │ + setName() → notifyObservers()                     │    │
│  │ + setGrade() → notifyObservers()                    │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
          ▲                         │
          │ updates                 │ notifies
          │                         ▼
┌─────────────────┐     ┌─────────────────────────────────────┐
│    Controller   │     │                      View             │
│(StudentController)    │           (StudentView, JsonView)     │
├─────────────────┤     ├─────────────────────────────────────┤
│ - model         │     │ + update(student)                   │
│ - view          │     │ + displayStudentDetails()           │
│ + setStudentName()    │                                     │
│ + setStudentGrade()   │                                     │
└─────────────────┘     └─────────────────────────────────────┘
          │
          │ user input
          ▼
     [User Interface]
```

## Component Responsibilities

| Component | Responsibility | Example |
|-----------|---------------|---------|
| Model | Data, business rules, state | Student data, validation |
| View | Display, presentation | HTML, console, JSON |
| Controller | Input handling, coordination | Handle form submission |

## Pros
- ✅ Separation of concerns
- ✅ Multiple views for same model
- ✅ Easy to modify UI without changing business logic
- ✅ Better testability
- ✅ Parallel development possible

## Cons
- ❌ Increased complexity for simple applications
- ❌ Tight coupling between view and controller
- ❌ Can lead to many classes

## When to Use
- For applications with multiple views
- When UI changes frequently
- For complex applications needing clear separation
- Web applications, GUI applications

## Related Patterns
- **Observer**: Model notifies views
- **Strategy**: Controller as strategy
- **Composite**: Complex view hierarchies
- **Factory**: Create views/controllers

## Real-World Examples
- Spring MVC
- Ruby on Rails
- ASP.NET MVC
- JavaServer Faces (JSF)
- Angular, React (modern variants)
