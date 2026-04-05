package com.patterns.principles.solid.isp;

/**
 * VIOLATION: Robot is forced to implement eat() and sleep()
 * even though those operations make no sense for a machine.
 * This is the "fat interface" problem ISP addresses.
 */
public class RobotViolation implements WorkerViolation {

    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Forced to implement — a lie or a no-op
        throw new UnsupportedOperationException("Robots don't eat!");
    }

    @Override
    public void sleep() {
        // Forced to implement — another lie
        throw new UnsupportedOperationException("Robots don't sleep!");
    }
}
