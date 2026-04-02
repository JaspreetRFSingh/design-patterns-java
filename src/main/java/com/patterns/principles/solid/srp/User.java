package com.patterns.principles.solid.srp;

/**
 * Single Responsibility Principle — correct implementation.
 * This class has ONE responsibility: represent a user and its core data.
 * Changes to email logic, DB logic, or validation rules do NOT touch this class.
 */
public class User {

    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}
