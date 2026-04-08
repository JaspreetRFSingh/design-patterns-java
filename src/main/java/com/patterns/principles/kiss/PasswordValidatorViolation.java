package com.patterns.principles.kiss;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * VIOLATION of KISS (Keep It Simple, Stupid).
 * Over-engineered password validator with unnecessary complexity:
 * a pipeline, a result wrapper, Strategy objects — for a 4-rule check.
 */
public class PasswordValidatorViolation {

    // Strategy interface for each rule — overkill for this use case
    interface ValidationRule {
        ValidationResult validate(String password);
    }

    record ValidationResult(boolean passed, String message) {}

    // Each trivial rule wrapped in its own class
    static class LengthRule implements ValidationRule {
        @Override public ValidationResult validate(String p) {
            return p.length() >= 8
                    ? new ValidationResult(true, "OK")
                    : new ValidationResult(false, "Too short");
        }
    }

    static class UpperCaseRule implements ValidationRule {
        private static final Pattern UPPER = Pattern.compile("[A-Z]");
        @Override public ValidationResult validate(String p) {
            return UPPER.matcher(p).find()
                    ? new ValidationResult(true, "OK")
                    : new ValidationResult(false, "No uppercase");
        }
    }

    static class DigitRule implements ValidationRule {
        private static final Pattern DIGIT = Pattern.compile("\\d");
        @Override public ValidationResult validate(String p) {
            return DIGIT.matcher(p).find()
                    ? new ValidationResult(true, "OK")
                    : new ValidationResult(false, "No digit");
        }
    }

    static class SpecialCharRule implements ValidationRule {
        private static final Pattern SPECIAL = Pattern.compile("[!@#$%^&*]");
        @Override public ValidationResult validate(String p) {
            return SPECIAL.matcher(p).find()
                    ? new ValidationResult(true, "OK")
                    : new ValidationResult(false, "No special char");
        }
    }

    private final List<ValidationRule> rules = new ArrayList<>();

    public PasswordValidatorViolation() {
        rules.add(new LengthRule());
        rules.add(new UpperCaseRule());
        rules.add(new DigitRule());
        rules.add(new SpecialCharRule());
    }

    public boolean validate(String password) {
        for (ValidationRule rule : rules) {
            ValidationResult result = rule.validate(password);
            if (!result.passed()) {
                System.out.println("Validation failed: " + result.message());
                return false;
            }
        }
        return true;
    }
}
