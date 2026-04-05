package com.patterns.principles.solid.isp;

import java.util.List;

/**
 * Demonstrates the Interface Segregation Principle (ISP).
 */
public class ISPDemo {

    public static void main(String[] args) {
        System.out.println("=== ISP Violation ===");
        RobotViolation badRobot = new RobotViolation();
        badRobot.work();
        try {
            badRobot.eat(); // throws — forced implementation
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== ISP Correct Implementation ===");
        HumanWorker alice = new HumanWorker("Alice");
        Robot r2d2 = new Robot("R2-D2");

        System.out.println("-- All workers work --");
        List<Workable> workers = List.of(alice, r2d2);
        workers.forEach(Workable::work);

        System.out.println();
        System.out.println("-- Only humans eat and sleep --");
        alice.eat();
        alice.sleep();

        System.out.println();
        System.out.println("Robot has no eat()/sleep() — no stubs, no exceptions.");
    }
}
