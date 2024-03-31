package com.patterns.additional.mvc;

/**
 * Demo class for MVC Pattern
 */
public class MVCDemo {
    public static void main(String[] args) {
        System.out.println("=== MVC Pattern Demo ===\n");

        // Create model
        Student student = new Student("S001", "John Doe", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial state
        System.out.println("--- Initial State ---");
        controller.updateView();

        // Update through controller
        System.out.println("\n--- Updating Student Name ---");
        controller.setStudentName("Jane Smith");

        // Add another view
        System.out.println("\n--- Adding JSON View ---");
        controller.addView(new JsonStudentView());

        // Update grade - both views will update
        System.out.println("\n--- Updating Grade (both views notified) ---");
        controller.setStudentGrade("A+");

        // Remove console view
        System.out.println("\n--- Removing Console View ---");
        controller.removeView(view);

        // Update - only JSON view will update
        System.out.println("\n--- Updating Name (only JSON view notified) ---");
        controller.setStudentName("Bob Johnson");
    }
}
