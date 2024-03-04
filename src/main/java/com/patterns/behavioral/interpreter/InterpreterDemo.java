package com.patterns.behavioral.interpreter;

/**
 * Demo class for Interpreter Pattern
 */
public class InterpreterDemo {
    public static void main(String[] args) {
        System.out.println("=== Interpreter Pattern Demo ===\n");

        // Build expression trees for different rules
        
        // Rule 1: Contains "Java" OR "Python"
        Expression javaOrPython = new OrExpression(
            new TerminalExpression("Java"),
            new TerminalExpression("Python")
        );

        // Rule 2: Contains "Programming" AND "Language"
        Expression programmingLanguage = new AndExpression(
            new TerminalExpression("Programming"),
            new TerminalExpression("Language")
        );

        // Rule 3: Complex rule - (Java OR Python) AND (Programming)
        Expression complexRule = new AndExpression(
            javaOrPython,
            new TerminalExpression("Programming")
        );

        // Test sentences
        String[] sentences = {
            "I love Java programming",
            "Python is a great language",
            "Programming in Java is fun",
            "C++ is also a programming language",
            "Java Programming Language"
        };

        System.out.println("Testing Rule 1: Contains 'Java' OR 'Python'");
        System.out.println("=".repeat(50));
        for (String sentence : sentences) {
            boolean result = javaOrPython.interpret(sentence);
            System.out.println("'" + sentence + "' → " + result);
        }

        System.out.println("\nTesting Rule 2: Contains 'Programming' AND 'Language'");
        System.out.println("=".repeat(50));
        for (String sentence : sentences) {
            boolean result = programmingLanguage.interpret(sentence);
            System.out.println("'" + sentence + "' → " + result);
        }

        System.out.println("\nTesting Rule 3: (Java OR Python) AND Programming");
        System.out.println("=".repeat(50));
        for (String sentence : sentences) {
            boolean result = complexRule.interpret(sentence);
            System.out.println("'" + sentence + "' → " + result);
        }
    }
}
