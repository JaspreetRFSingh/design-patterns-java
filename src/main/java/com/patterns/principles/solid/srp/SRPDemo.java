package com.patterns.principles.solid.srp;

/**
 * Demonstrates the Single Responsibility Principle (SRP).
 */
public class SRPDemo {

    public static void main(String[] args) {
        System.out.println("=== SRP Violation ===");
        UserViolation bad = new UserViolation("Alice", "alice@example.com");
        if (bad.isValid()) {
            bad.saveToDatabase();
            bad.sendWelcomeEmail();
        }

        System.out.println();
        System.out.println("=== SRP Correct Implementation ===");
        User user = new User("Bob", "bob@example.com");
        UserValidator validator = new UserValidator();
        UserRepository repo = new UserRepository();
        EmailService emailService = new EmailService();

        if (validator.isValid(user)) {
            repo.save(user);
            emailService.sendWelcomeEmail(user);
        }

        System.out.println();
        System.out.println("Each class has exactly one reason to change.");
    }
}
