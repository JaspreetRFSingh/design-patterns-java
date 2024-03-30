package com.patterns.additional.objectpool;

/**
 * Pooled Object - Expensive object that can be reused
 */
public class DatabaseConnection {
    private static int connectionCounter = 0;
    private int connectionId;
    private boolean inUse;

    public DatabaseConnection() {
        this.connectionId = ++connectionCounter;
        this.inUse = false;
        System.out.println("Creating new DatabaseConnection-" + connectionId);
        // Simulate expensive connection setup
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void query(String sql) {
        if (!inUse) {
            throw new IllegalStateException("Connection not checked out");
        }
        System.out.println("Connection-" + connectionId + " executing: " + sql);
        // Simulate query execution
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        System.out.println("Connection-" + connectionId + " closed permanently");
    }

    public int getConnectionId() {
        return connectionId;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
