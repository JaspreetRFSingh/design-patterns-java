package com.patterns.principles.solid.srp;

/**
 * Single responsibility: persist User objects.
 * If DB technology changes, only this class changes.
 */
public class UserRepository {

    public void save(User user) {
        System.out.println("[DB] Saving " + user + " to database...");
    }
}
