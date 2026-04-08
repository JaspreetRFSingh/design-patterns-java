package com.patterns.principles.kiss;

/**
 * KISS — Keep It Simple, Stupid.
 * Same four-rule password check expressed as four readable boolean conditions.
 * No Strategy objects, no pipelines, no wrappers — just clear, direct logic.
 */
public class PasswordValidator {

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("Validation failed: Too short (minimum 8 characters)");
            return false;
        }
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            System.out.println("Validation failed: Must contain at least one uppercase letter");
            return false;
        }
        if (!password.chars().anyMatch(Character::isDigit)) {
            System.out.println("Validation failed: Must contain at least one digit");
            return false;
        }
        if (!password.chars().anyMatch(c -> "!@#$%^&*".indexOf(c) >= 0)) {
            System.out.println("Validation failed: Must contain at least one special character (!@#$%^&*)");
            return false;
        }
        return true;
    }
}
