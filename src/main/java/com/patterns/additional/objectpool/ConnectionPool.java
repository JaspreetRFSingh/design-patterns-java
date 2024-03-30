package com.patterns.additional.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Object Pool - Manages reusable database connections
 */
public class ConnectionPool {
    private List<DatabaseConnection> available = new ArrayList<>();
    private List<DatabaseConnection> inUse = new ArrayList<>();
    private int maxPoolSize;
    private int createdCount = 0;

    public ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized DatabaseConnection getConnection() {
        // Try to get an available connection
        if (!available.isEmpty()) {
            DatabaseConnection connection = available.remove(available.size() - 1);
            connection.setInUse(true);
            inUse.add(connection);
            System.out.println("Reusing Connection-" + connection.getConnectionId());
            return connection;
        }

        // Create new connection if under limit
        if (createdCount < maxPoolSize) {
            DatabaseConnection connection = new DatabaseConnection();
            createdCount++;
            connection.setInUse(true);
            inUse.add(connection);
            return connection;
        }

        // Pool exhausted - wait or throw exception
        System.out.println("Pool exhausted! Waiting for available connection...");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return getConnection(); // Retry
    }

    public synchronized void releaseConnection(DatabaseConnection connection) {
        if (inUse.remove(connection)) {
            connection.setInUse(false);
            available.add(connection);
            System.out.println("Released Connection-" + connection.getConnectionId() + " back to pool");
            notify(); // Wake up waiting threads
        }
    }

    public int getAvailableCount() {
        return available.size();
    }

    public int getInUseCount() {
        return inUse.size();
    }

    public int getTotalCreated() {
        return createdCount;
    }

    public synchronized void shutdown() {
        for (DatabaseConnection connection : available) {
            connection.close();
        }
        for (DatabaseConnection connection : inUse) {
            connection.close();
        }
        available.clear();
        inUse.clear();
    }
}
