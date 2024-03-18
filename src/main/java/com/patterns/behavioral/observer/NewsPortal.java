package com.patterns.behavioral.observer;

/**
 * Concrete Observer - Online news portal
 */
public class NewsPortal implements Observer {
    private String portalName;

    public NewsPortal(String portalName) {
        this.portalName = portalName;
    }

    @Override
    public void update(String message) {
        System.out.println(portalName + " publishing online: " + message);
    }

    @Override
    public String toString() {
        return portalName;
    }
}
