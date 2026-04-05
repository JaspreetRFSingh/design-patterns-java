package com.patterns.principles.solid.isp;

/**
 * Human implements all three capabilities — each makes sense for a person.
 * No forced stubs or exceptions.
 */
public class HumanWorker implements Workable, Eatable, Sleepable {

    private final String name;

    public HumanWorker(String name) { this.name = name; }

    @Override
    public void work() {
        System.out.println(name + " is working diligently.");
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating lunch.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping for 8 hours.");
    }
}
