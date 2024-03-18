package com.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject Interface - Objects that can be observed
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);
}
