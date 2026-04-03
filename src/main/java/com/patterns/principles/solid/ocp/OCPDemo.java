package com.patterns.principles.solid.ocp;

import java.util.List;

/**
 * Demonstrates the Open/Closed Principle (OCP).
 */
public class OCPDemo {

    public static void main(String[] args) {
        System.out.println("=== OCP Violation ===");
        AreaCalculatorViolation badCalc = new AreaCalculatorViolation();
        System.out.printf("Circle area: %.2f%n", badCalc.calculateArea(new CircleViolation(5)));
        System.out.printf("Rectangle area: %.2f%n", badCalc.calculateArea(new RectangleViolation(4, 6)));
        System.out.println("(Adding Triangle would require editing AreaCalculatorViolation)");

        System.out.println();
        System.out.println("=== OCP Correct Implementation ===");
        List<Shape> shapes = List.of(
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 8)  // Added with ZERO changes to AreaCalculator
        );

        AreaCalculator calc = new AreaCalculator();
        for (Shape s : shapes) {
            System.out.printf("%-30s area = %.2f%n", s, s.area());
        }
        System.out.printf("Total area: %.2f%n", calc.totalArea(shapes));
        System.out.println("Triangle was added without modifying AreaCalculator.");
    }
}
