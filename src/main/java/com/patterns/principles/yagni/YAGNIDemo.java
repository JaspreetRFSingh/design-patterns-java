package com.patterns.principles.yagni;

/**
 * Demonstrates the YAGNI (You Aren't Gonna Need It) principle.
 */
public class YAGNIDemo {

    public static void main(String[] args) {
        System.out.println("=== YAGNI Violation ===");
        UserServiceViolation bloated = new UserServiceViolation();
        bloated.addUser("alice");
        bloated.addUser("bob");
        System.out.println("Retrieved: " + bloated.getUser(0));
        System.out.println("(Service also has roles, audit, CSV export, archiving, plugins — all unused)");

        System.out.println();
        System.out.println("=== YAGNI Correct Implementation ===");
        UserService lean = new UserService();
        lean.addUser("alice");
        lean.addUser("bob");
        System.out.println("Retrieved: " + lean.getUser(0));
        System.out.println("Total users: " + lean.getUserCount());
        System.out.println("Contains only what is needed today.");
    }
}
