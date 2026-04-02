package com.patterns.principles.solid.srp;

/**
 * VIOLATION of Single Responsibility Principle.
 * This class handles user data, validation, persistence, AND email notifications.
 * It has multiple reasons to change: if email logic changes, if DB logic changes,
 * or if user validation rules change — all force edits to this one class.
 */
public class UserViolation {

    private String name;
    private String email;

    public UserViolation(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Responsibility 1: Hold user data
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Responsibility 2: Validate user data
    public boolean isValid() {
        return name != null && !name.isBlank()
                && email != null && email.contains("@");
    }

    // Responsibility 3: Persist user (should be in a repository)
    public void saveToDatabase() {
        System.out.println("[DB] Saving user '" + name + "' to database...");
        // Imagine JDBC code here — now this class depends on DB details
    }

    // Responsibility 4: Send welcome email (should be in a mail service)
    public void sendWelcomeEmail() {
        System.out.println("[Email] Sending welcome email to " + email);
        // Imagine SMTP code here — now this class depends on email server details
    }
}
