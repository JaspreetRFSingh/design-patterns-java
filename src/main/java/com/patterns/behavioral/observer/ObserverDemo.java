package com.patterns.behavioral.observer;

/**
 * Demo class for Observer Pattern
 */
public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo ===\n");

        // Create subject
        NewsAgency newsAgency = new NewsAgency();

        // Create observers
        Observer cnn = new TVChannel("CNN");
        Observer bbc = new TVChannel("BBC");
        Observer reuters = new NewsPortal("Reuters.com");
        Observer app = new MobileApp("NewsApp");

        // Attach observers
        newsAgency.attach(cnn);
        newsAgency.attach(bbc);
        newsAgency.attach(reuters);
        newsAgency.attach(app);

        // Publish news
        newsAgency.setNews("Stock market reaches all-time high!");

        // Detach an observer
        System.out.println("\n--- Unsubscribing BBC ---");
        newsAgency.detach(bbc);

        // Publish more news
        newsAgency.setNews("New technology breakthrough announced!");

        // Attach new observer
        System.out.println("\n--- Subscribing Fox News ---");
        newsAgency.attach(new TVChannel("Fox News"));

        // Publish final news
        newsAgency.setNews("Weather alert: Storm approaching!");
    }
}
