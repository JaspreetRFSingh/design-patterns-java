package com.patterns.additional.objectpool;

/**
 * Demo class for Object Pool Pattern
 */
public class ObjectPoolDemo {
    public static void main(String[] args) {
        System.out.println("=== Object Pool Pattern Demo ===\n");

        // Create pool with max 3 connections
        ConnectionPool pool = new ConnectionPool(3);

        System.out.println("--- Getting connections (creates new) ---");
        DatabaseConnection conn1 = pool.getConnection();
        DatabaseConnection conn2 = pool.getConnection();
        DatabaseConnection conn3 = pool.getConnection();

        System.out.println("\nPool status: Available=" + pool.getAvailableCount() + 
                          ", In Use=" + pool.getInUseCount() + 
                          ", Total Created=" + pool.getTotalCreated());

        System.out.println("\n--- Using connections ---");
        conn1.query("SELECT * FROM users");
        conn2.query("SELECT * FROM orders");
        conn3.query("SELECT * FROM products");

        System.out.println("\n--- Releasing connections back to pool ---");
        pool.releaseConnection(conn1);
        pool.releaseConnection(conn2);

        System.out.println("\nPool status: Available=" + pool.getAvailableCount() + 
                          ", In Use=" + pool.getInUseCount());

        System.out.println("\n--- Getting connections (reuses from pool) ---");
        DatabaseConnection conn4 = pool.getConnection(); // Reuses conn1 or conn2
        DatabaseConnection conn5 = pool.getConnection(); // Reuses the other

        System.out.println("\nPool status: Available=" + pool.getAvailableCount() + 
                          ", In Use=" + pool.getInUseCount() + 
                          ", Total Created=" + pool.getTotalCreated());

        System.out.println("\n--- Using reused connections ---");
        conn4.query("UPDATE users SET name='test'");
        conn5.query("DELETE FROM temp");

        // Cleanup
        pool.releaseConnection(conn3);
        pool.releaseConnection(conn4);
        pool.releaseConnection(conn5);
        pool.shutdown();
    }
}
