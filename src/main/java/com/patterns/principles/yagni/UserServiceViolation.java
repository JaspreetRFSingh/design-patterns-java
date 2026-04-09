package com.patterns.principles.yagni;

import java.util.ArrayList;
import java.util.List;

/**
 * VIOLATION of YAGNI (You Aren't Gonna Need It).
 * This service was built to manage users, but includes speculative features
 * that were never asked for: role management, audit trails, bulk export,
 * archival, and a plugin system — none of which have requirements yet.
 */
public class UserServiceViolation {

    private final List<String> users = new ArrayList<>();

    // Actual requirement: add a user
    public void addUser(String username) {
        users.add(username);
        System.out.println("Added user: " + username);
    }

    // Actual requirement: get a user
    public String getUser(int index) {
        return users.get(index);
    }

    // --- Speculative features below — never actually required ---

    // "We might need roles someday"
    public void assignRole(String username, String role) {
        System.out.println("[UNUSED] Assign role " + role + " to " + username);
    }

    // "We might need audit trails"
    public void logAuditEvent(String username, String action) {
        System.out.println("[UNUSED] Audit: " + username + " → " + action);
    }

    // "We might export users"
    public String exportToCSV() {
        return "[UNUSED] CSV export not yet needed";
    }

    // "We might archive old users"
    public void archiveUser(String username) {
        System.out.println("[UNUSED] Archived: " + username);
    }

    // "We might need a plugin hook"
    public void registerPlugin(Object plugin) {
        System.out.println("[UNUSED] Plugin registered: " + plugin);
    }
}
