package com.patterns.additional.mvc;

/**
 * View - Displays student data as JSON
 */
public class JsonStudentView implements Observer {
    @Override
    public void update(Student student) {
        System.out.println("\n=== JSON View Updated ===");
        System.out.println("{");
        System.out.println("  \"id\": \"" + student.getId() + "\",");
        System.out.println("  \"name\": \"" + student.getName() + "\",");
        System.out.println("  \"grade\": \"" + student.getGrade() + "\"");
        System.out.println("}");
    }
}
