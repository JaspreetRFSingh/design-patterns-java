package com.patterns.principles.solid.srp;

/**
 * Single responsibility: validate User objects.
 * If validation rules change, only this class changes.
 */
public class UserValidator {

    public boolean isValid(User user) {
        return user.getName() != null && !user.getName().isBlank()
                && user.getEmail() != null && user.getEmail().contains("@");
    }
}
