package com.patterns.behavioral.observer;

/**
 * Concrete Observer - TV channel displays news
 */
public class TVChannel implements Observer {
    private String channelName;

    public TVChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String message) {
        System.out.println(channelName + " broadcasting: " + message);
    }

    @Override
    public String toString() {
        return channelName;
    }
}
