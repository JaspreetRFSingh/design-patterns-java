package com.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject - News agency that notifies subscribers
 */
public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println(observer + " subscribed to news");
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println(observer + " unsubscribed from news");
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setNews(String news) {
        this.news = news;
        System.out.println("\n=== Breaking News ===");
        System.out.println("News Agency: " + news);
        notifyObservers(news);
    }

    public String getNews() {
        return news;
    }
}
