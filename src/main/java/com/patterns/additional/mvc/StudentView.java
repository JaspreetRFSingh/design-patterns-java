package com.patterns.additional.mvc;

/**
 * View - Displays student data (Console View)
 */
public class StudentView implements Observer {
    @Override
    public void update(Student student) {
        System.out.println("\n=== Student View Updated ===");
        displayStudentDetails(student);
    }

    public void displayStudentDetails(Student student) {
        System.out.println("Student Information:");
        System.out.println("  ID: " + student.getId());
        System.out.println("  Name: " + student.getName());
        System.out.println("  Grade: " + student.getGrade());
    }
}
