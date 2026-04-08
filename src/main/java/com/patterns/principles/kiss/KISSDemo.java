package com.patterns.principles.kiss;

import java.util.List;

/**
 * Demonstrates the KISS (Keep It Simple, Stupid) principle.
 */
public class KISSDemo {

    public static void main(String[] args) {
        List<String> passwords = List.of("abc", "password", "Password1", "Password1!");

        System.out.println("=== KISS Violation (over-engineered) ===");
        PasswordValidatorViolation complex = new PasswordValidatorViolation();
        for (String pwd : passwords) {
            System.out.printf("'%s' → %s%n", pwd, complex.validate(pwd) ? "VALID" : "INVALID");
        }

        System.out.println();
        System.out.println("=== KISS Correct Implementation (simple & clear) ===");
        PasswordValidator simple = new PasswordValidator();
        for (String pwd : passwords) {
            System.out.printf("'%s' → %s%n", pwd, simple.validate(pwd) ? "VALID" : "INVALID");
        }

        System.out.println();
        System.out.println("Both produce identical results — simpler code is easier to read and maintain.");
    }
}
