package com.patterns.principles.yagni;

import java.util.ArrayList;
import java.util.List;

/**
 * YAGNI — correct implementation.
 * Implements exactly what is currently required: add and retrieve users.
 * Nothing more. If roles or auditing are needed later, they will be added then —
 * with full knowledge of the actual requirements.
 */
public class UserService {

    private final List<String> users = new ArrayList<>();

    public void addUser(String username) {
        users.add(username);
        System.out.println("Added user: " + username);
    }

    public String getUser(int index) {
        return users.get(index);
    }

    public int getUserCount() {
        return users.size();
    }
}
