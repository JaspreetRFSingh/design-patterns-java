package com.patterns.structural.bridge;

/**
 * Implementor Interface - Defines the implementation contract
 */
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    int getVolume();
}
