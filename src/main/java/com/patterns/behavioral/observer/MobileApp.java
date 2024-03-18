package com.patterns.behavioral.observer;

/**
 * Concrete Observer - Mobile app sends push notifications
 */
public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String message) {
        System.out.println(appName + " sending push notification: " + message);
    }

    @Override
    public String toString() {
        return appName;
    }
}
