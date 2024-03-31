package com.patterns.additional.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Model - Represents the data and business logic
 */
public class Student {
    private String id;
    private String name;
    private String grade;
    private List<Observer> observers = new ArrayList<>();

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', grade='" + grade + "'}";
    }
}
